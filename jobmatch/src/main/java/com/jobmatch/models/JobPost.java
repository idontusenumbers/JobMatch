package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.*;

@Entity
public class JobPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String jobCountry;
    private String industry;
    private String jobType;
    private String description;

    @Min(0)
    private int yearsExperience;

    @ManyToMany
    @JoinTable(name = "USER_FAVE_POSTS",
            joinColumns = @JoinColumn(name = "job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    protected Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "JOB_POST_SKILLS",
            joinColumns = @JoinColumn(name = "job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "ranked_skill_id"))
    protected Set<RankedSkill> skills = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "JOB_POST_CULTURES",
            joinColumns = @JoinColumn(name = "job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "ranked_culture_id"))
    protected Set<RankedCulture> cultures = new HashSet<>();

    @OneToOne
    @JoinColumn
    protected User creator;

    public JobPost() {
    }

    public JobPost(String jobTitle, String jobCountry, String industry, String jobType, int yearsExperience) {
        this.jobTitle = jobTitle;
        this.jobCountry = jobCountry;
        this.industry = industry;
        this.jobType = jobType;
        this.yearsExperience = yearsExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<RankedSkill> getSkills() {
        return skills;
    }

    public Set<RankedCulture> getCultures() {
        return cultures;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPost jobPost = (JobPost) o;

        if (yearsExperience != jobPost.yearsExperience) return false;
        if (!jobTitle.equals(jobPost.jobTitle)) return false;
        if (!jobCountry.equals(jobPost.jobCountry)) return false;
        if (!industry.equals(jobPost.industry)) return false;
        return jobType.equals(jobPost.jobType);
    }

    @Override
    public int hashCode() {
        int result = jobTitle.hashCode();
        result = 31 * result + jobCountry.hashCode();
        result = 31 * result + industry.hashCode();
        result = 31 * result + jobType.hashCode();
        result = 31 * result + yearsExperience;
        return result;
    }

    public static Map<String, String> getCountries() {
        return countries;
    }

    public static List<String> getCountryList() {
        return new ArrayList<>(countries.values());
    }

    public static final Map<String, String> countries;

    static {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("AF", "Afghanistan");
        map.put("AL", "Albania");
        map.put("DZ", "Algeria");
        map.put("AS", "American Samoa");
        map.put("AD", "Andorra");
        map.put("AO", "Angola");
        map.put("AI", "Anguilla ");
        map.put("AQ", "Antarctica");
        map.put("AG", "Antigua and Barbuda");
        map.put("AR", "Argentina");
        map.put("AM", "Armenia");
        map.put("AW", "Aruba");
        map.put("AU", "Australia");
        map.put("AT", "Austria");
        map.put("AZ", "Azerbaijan");
        map.put("BS", "Bahamas");
        map.put("BH", "Bahrain");
        map.put("BD", "Bangladesh");
        map.put("BB", "Barbados");
        map.put("BY", "Belarus");
        map.put("BE", "Belgium");
        map.put("BZ", "Belize");
        map.put("BJ", "Benin");
        map.put("BM", "Bermuda");
        map.put("BT", "Bhutan");
        map.put("BO", "'Bolivia, Plurinational State Of'  ");
        map.put("BQ", "'Bonaire, Saint Eustatius and Saba'");
        map.put("BA", "Bosnia and Herzegovina");
        map.put("BW", "Botswana");
        map.put("BV", "Bouvet Island");
        map.put("BR", "Brazil");
        map.put("IO", "British Indian Ocean Territory");
        map.put("BN", "Brunei Darussalam");
        map.put("BG", "Bulgaria");
        map.put("BF", "Burkina Faso");
        map.put("BI", "Burundi");
        map.put("KH", "Cambodia");
        map.put("CM", "Cameroon");
        map.put("CA", "Canada");
        map.put("CV", "Cape Verde  ");
        map.put("KY", "Cayman Islands");
        map.put("CF", "Central African Republic");
        map.put("TD", "Chad");
        map.put("CL", "Chile");
        map.put("CN", "China");
        map.put("CX", "Christmas Island");
        map.put("CC", "Cocos (Keeling) Islands");
        map.put("CO", "Colombia");
        map.put("KM", "Comoros");
        map.put("CG", "Congo");
        map.put("CD", "'Congo, The Democratic Republic Of The'");
        map.put("CK", "Cook Islands");
        map.put("CR", "Costa Rica");
        map.put("HR", "Croatia");
        map.put("CU", "Cuba");
        map.put("CW", "Curaçao");
        map.put("CY", "Cyprus");
        map.put("CZ", "Czech Republic");
        map.put("CI", "Côte D\'Ivoire");
        map.put("DK", "Denmark");
        map.put("DJ", "Djibouti");
        map.put("DM", "Dominica");
        map.put("DO", "Dominican Republic");
        map.put("EC", "Ecuador");
        map.put("EG", "Egypt");
        map.put("SV", "El Salvador");
        map.put("GQ", "Equatorial Guinea");
        map.put("ER", "Eritrea");
        map.put("EE", "Estonia");
        map.put("ET", "Ethiopia");
        map.put("FK", "Falkland Islands  (Malvinas)");
        map.put("FO", "Faroe Islands");
        map.put("FJ", "Fiji");
        map.put("FI", "Finland");
        map.put("FR", "France");
        map.put("GF", "French Guiana");
        map.put("PF", "French Polynesia");
        map.put("TF", "French Southern Territories");
        map.put("GA", "Gabon");
        map.put("GM", "Gambia");
        map.put("GE", "Georgia");
        map.put("DE", "Germany");
        map.put("GH", "Ghana ");
        map.put("GI", "Gibraltar");
        map.put("GR", "Greece");
        map.put("GL", "Greenland");
        map.put("GD", "Grenada");
        map.put("GP", "Guadeloupe");
        map.put("GU", "Guam");
        map.put("GT", "Guatemala");
        map.put("GG", "Guernsey");
        map.put("GN", "Guinea");
        map.put("GW", "Guinea-Bissau");
        map.put("GY", "Guyana");
        map.put("HT", "Haiti");
        map.put("HM", "Heard and McDonald Islands");
        map.put("VA", "Holy See (Vatican City State)");
        map.put("HN", "Honduras");
        map.put("HK", "Hong Kong");
        map.put("HU", "Hungary");
        map.put("IS", "Iceland");
        map.put("IN", "India");
        map.put("ID", "Indonesia");
        map.put("IR", "'Iran, Islamic Republic Of'");
        map.put("IQ", "Iraq");
        map.put("IE", "Ireland");
        map.put("IM", "Isle of Man");
        map.put("IL", "Israel");
        map.put("IT", "Italy");
        map.put("JM", "Jamaica");
        map.put("JP", "Japan");
        map.put("JE", "Jersey");
        map.put("JO", "Jordan");
        map.put("KZ", "Kazakhstan");
        map.put("KE", "Kenya");
        map.put("KI", "Kiribati");
        map.put("KP", "'Korea, Democratic People\'s Republic Of'");
        map.put("KR", "'Korea, Republic of'");
        map.put("KW", "Kuwait");
        map.put("KG", "Kyrgyzstan");
        map.put("LA", "Lao People\'s Democratic Republic");
        map.put("LV", "Latvia");
        map.put("LB", "Lebanon");
        map.put("LS", "Lesotho");
        map.put("LR", "Liberia");
        map.put("LY", "Libyan Arab Jamahiriya");
        map.put("LI", "Liechtenstein");
        map.put("LT", "Lithuania");
        map.put("LU", "Luxembourg");
        map.put("MO", "Macao");
        map.put("MK", "'Macedonia, the Former Yugoslav Republic Of'");
        map.put("MG", "Madagascar");
        map.put("MW", "Malawi");
        map.put("MY", "Malaysia");
        map.put("MV", "Maldives");
        map.put("ML", "Mali");
        map.put("MT", "Malta");
        map.put("MH", "Marshall Islands");
        map.put("MQ", "Martinique");
        map.put("MR", "Mauritania");
        map.put("MU", "Mauritius");
        map.put("YT", "Mayotte");
        map.put("MX", "Mexico");
        map.put("FM", "'Micronesia, Federated States Of'");
        map.put("MD", "'Moldova, Republic of'");
        map.put("MC", "Monaco");
        map.put("MN", "Mongolia");
        map.put("ME", "Montenegro");
        map.put("MS", "Montserrat");
        map.put("MA", "Morocco");
        map.put("MZ", "Mozambique");
        map.put("MM", "Myanmar");
        map.put("NA", "Namibia");
        map.put("NR", "Nauru");
        map.put("NP", "Nepal");
        map.put("NL", "Netherlands");
        map.put("AN", "Netherlands Antilles");
        map.put("NC", "New Caledonia");
        map.put("NZ", "New Zealand");
        map.put("NI", "Nicaragua");
        map.put("NE", "Niger");
        map.put("NG", "Nigeria");
        map.put("NU", "Niue");
        map.put("NF", "Norfolk Island");
        map.put("MP", "Northern Mariana Islands");
        map.put("NO", "Norway");
        map.put("OM", "Oman");
        map.put("PK", "Pakistan");
        map.put("PW", "Palau");
        map.put("PS", "'Palestinian Territory, Occupied'");
        map.put("PA", "Panama");
        map.put("PG", "Papua New Guinea");
        map.put("PY", "Paraguay");
        map.put("PE", "Peru");
        map.put("PH", "Philippines");
        map.put("PN", "Pitcairn");
        map.put("PL", "Poland");
        map.put("PT", "Portugal");
        map.put("PR", "Puerto Rico");
        map.put("QA", "Qatar");
        map.put("RO", "Romania");
        map.put("RU", "Russian Federation");
        map.put("RW", "Rwanda");
        map.put("RE", "Réunion");
        map.put("BL", "Saint Barthélemy");
        map.put("SH", "'Saint Helena, Ascension and Tristan Da Cunha'");
        map.put("KN", "Saint Kitts And Nevis");
        map.put("LC", "Saint Lucia");
        map.put("MF", "Saint Martin");
        map.put("PM", "Saint Pierre And Miquelon");
        map.put("VC", "Saint Vincent And The Grenedines");
        map.put("WS", "Samoa");
        map.put("SM", "San Marino");
        map.put("ST", "Sao Tome and Principe");
        map.put("SA", "Saudi Arabia");
        map.put("SN", "Senegal");
        map.put("RS", "Serbia");
        map.put("SC", "Seychelles");
        map.put("SL", "Sierra Leone");
        map.put("SG", "Singapore");
        map.put("SX", "Sint Maarten (Dutch part)");
        map.put("SK", "Slovakia");
        map.put("SI", "Slovenia");
        map.put("SB", "Solomon Islands");
        map.put("SO", "Somalia");
        map.put("ZA", "South Africa");
        map.put("GS", "South Georgia and the South Sandwich Islands");
        map.put("ES", "Spain");
        map.put("LK", "Sri Lanka");
        map.put("SD", "Sudan");
        map.put("SR", "Suriname");
        map.put("SJ", "Svalbard And Jan Mayen");
        map.put("SZ", "Swaziland");
        map.put("SE", "Sweden");
        map.put("CH", "Switzerland");
        map.put("SY", "Syrian Arab Republic  ");
        map.put("TW", "'Taiwan, Province Of China'");
        map.put("TJ", "Tajikistan");
        map.put("TZ", "'Tanzania, United Republic of'");
        map.put("TH", "Thailand");
        map.put("TL", "Timor-Leste");
        map.put("TG", "Togo");
        map.put("TK", "Tokelau");
        map.put("TO", "Tonga");
        map.put("TT", "Trinidad and Tobago");
        map.put("TN", "Tunisia");
        map.put("TR", "Turkey");
        map.put("TM", "Turkmenistan");
        map.put("TC", "Turks and Caicos Islands");
        map.put("TV", "Tuvalu");
        map.put("UG", "Uganda");
        map.put("UA", "Ukraine");
        map.put("AE", "United Arab Emirates");
        map.put("GB", "United Kingdom");
        map.put("US", "United States");
        map.put("UM", "United States Minor Outlying Islands");
        map.put("UY", "Uruguay");
        map.put("UZ", "Uzbekistan");
        map.put("VU", "Vanuatu");
        map.put("VE", "'Venezuela, Bolivarian Republic of' ");
        map.put("VN", "Viet Nam");
        map.put("VG", "'Virgin Islands, British'");
        map.put("VI", "'Virgin Islands, U.S.'");
        map.put("WF", "Wallis and Futuna");
        map.put("EH", "Western Sahara");
        map.put("YE", "Yemen");
        map.put("ZM", "Zambia");
        map.put("ZW", "Zimbabwe");
        map.put("AX", "Åland Islands");
        countries = map;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobCountry='" + jobCountry + '\'' +
                ", industry='" + industry + '\'' +
                ", jobType='" + jobType + '\'' +
                ", description='" + description + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", users=" + users +
                ", skills=" + skills +
                ", cultures=" + cultures +
                ", creator=" + creator +
                '}';
    }
}
