package com.jobmatch.models;

import com.jobmatch.repositories.CultureRepository;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Entity
public class RankedCulture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    protected Culture culture;

    @Min(0) @Max(10)
    protected int rank;

    public RankedCulture() {
    }

    public RankedCulture(Culture culture, int rank) {
        this.culture = culture;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankedCulture that = (RankedCulture) o;

        if (rank != that.rank) return false;
        return culture.equals(that.culture);

    }

    @Override
    public int hashCode() {
        int result = culture.hashCode();
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "UserCulture{" +
                "id=" + id +
                ", culture=" + culture +
                ", rank=" + rank +
                '}';
    }


    public static void updateCultureSet(String[] cultures, String[] ranks, Set<RankedCulture> cultureSet, CultureRepository cultureRepository) {
        cultureSet.clear();
        for (int i = 0; i < cultures.length; i++) {
            String s = cultures[i];
            if (!s.isEmpty()) {
                Culture culture = cultureRepository.findOne(Integer.valueOf(s));
                RankedCulture rankedCulture = new RankedCulture(culture, Integer.valueOf(ranks[i]));
                cultureSet.add(rankedCulture);
            }
        }
    }
       public static Map<String, String> getCulturesAndRanks(Set<RankedCulture> cultures) {
                return StreamSupport.stream(cultures.spliterator(), false)
                .collect(Collectors.toMap(rankedCulture -> String.valueOf(rankedCulture.getCulture().getId()),
                                          rankedCulture -> String.valueOf(rankedCulture.getRank())));
    }
}
