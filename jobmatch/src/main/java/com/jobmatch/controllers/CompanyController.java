package com.jobmatch.controllers;

import com.jobmatch.models.Company;
import com.jobmatch.models.RankedCulture;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.View;


@Controller
@RequestMapping("/companies")
public class CompanyController extends BaseController {

    @RequestMapping(value = "{companyId}/profile", method = RequestMethod.GET)
    public String getCompany(@PathVariable int companyId, Model model) {
        Company company = companyRepository.findOne(companyId);
        model.addAttribute("company", company);
        model.addAttribute("cultures", RankedCulture.getCulturesAndRanks(company.getCultures()));

        User user = getCurrentUser();
        if (user.getRole().getId() == Role.ADMIN || (user.getCompany() != null && user.getCompany().getId() == companyId)) {
            model.addAttribute("cultureOptions", cultureRepository.getMap());
            return "companies/edit";
        } else {
            return "companies/view";
        }
    }


    @RequestMapping(value = "{companyId}/profile", method = RequestMethod.POST)
    public View updateCompany(@PathVariable int companyId, @ModelAttribute Company company,
                              String[] cultures, String[] culturesRanks, Model model) {
        Company existingCompany = companyRepository.findOne(companyId);
        User user = getCurrentUser();

        if (user.getRole().getId() == Role.ADMIN || user.getCompany().getId() == companyId) {
            BeanUtils.copyProperties(company, existingCompany, "id");
            RankedCulture.updateCultureSet(cultures, culturesRanks, existingCompany.getCultures(), cultureRepository);
            companyRepository.save(existingCompany);
        } else {
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
        }

        return getRedirectView("/");
    }
}
