package com.jobmatch.viewmodels;

import com.jobmatch.models.RankedIdentifiable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RankMap<R extends RankedIdentifiable> {

    private List<R> rankables;
    private Map<Integer, Integer> ranks;

    public RankMap(Set<R> rankables) {
        this.rankables = StreamSupport.stream(rankables.spliterator(), false)
                .sorted((o1, o2) -> Integer.compare(o1.getRank(), o2.getRank()))
                .collect(Collectors.toList());

        this.ranks = StreamSupport.stream(rankables.spliterator(), false)
                .collect(Collectors.toMap(RankedIdentifiable::getRankedId, RankedIdentifiable::getRank));
    }

    public List<R> getSortedRankables() {
        return rankables;
    }

    public boolean contains(String id){
        return ranks.containsKey(Integer.parseInt(id));
    }
    public int getRank(String id){
        return ranks.get(Integer.parseInt(id));
    }

}
