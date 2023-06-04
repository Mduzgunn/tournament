package com.md.tournament.service;

import com.md.tournament.dto.ResultDTO;
import com.md.tournament.exception.ResultNotFoundException;
import com.md.tournament.model.Match;
import com.md.tournament.model.Result;

import java.util.List;

public interface ResultService {
    public List<Result> getAll();
    public Result get(Long id);
    public Result create(ResultDTO resultForm);
    public Result update(ResultDTO resultForm) throws ResultNotFoundException;
    public String delete(Long id) throws ResultNotFoundException;
    public void calculate(Match match, boolean updated);

}
