package com.md.tournament.service.impl;

import com.md.tournament.dto.ResultDTO;
import com.md.tournament.exception.MatchNotFoundException;
import com.md.tournament.exception.ResultNotFoundException;
import com.md.tournament.model.Match;
import com.md.tournament.model.Result;
import com.md.tournament.repository.ResultRepository;
import com.md.tournament.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    public static final int SCORING_PTS_WIN = 3;

    public static final int SCORING_PTS_DRAFT = 1;

    public static final int SCORING_PTS_LOSS = 0;


    private final ResultRepository resultRepository;
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    protected Result findResultById(Long id) {
        return resultRepository
                .findById(id)
                .orElseThrow(() -> new MatchNotFoundException("Result not found " + id));
    }

    public Result get(Long id) {
        return findResultById(id);
    }

    public List<Result> getAll() {
        return resultRepository.findAll();
    }

    public Result create(ResultDTO resultForm) {
        Result result = new Result(resultForm.getPlayed(), resultForm.getWin(), resultForm.getDraft(), resultForm.getLoss(), resultForm.getSeason(), resultForm.getTeam());

        return resultRepository.save(result);
    }

    public Result update(ResultDTO resultForm) throws ResultNotFoundException {
        Result result = findResultById(resultForm.getId());

        result.setPlayed(resultForm.getPlayed());
        result.setWin(resultForm.getWin());
        result.setDraft(resultForm.getDraft());
        result.setLoss(resultForm.getLoss());
        result.setSeason(resultForm.getSeason());
        result.setTeam(resultForm.getTeam());

        return resultRepository.save(result);
    }

    public String delete(Long id) throws ResultNotFoundException {
        resultRepository.deleteById(id);
        return "Result deleted successfully " + id;
    }

    public void calculate(Match match, boolean updated) {
        int pts = (updated) ? -1 : 1;

        Result resultHome = resultRepository.findBySeasonAndTeam(match.getTournament().getSeason(), match.getHomeTeam());
        if (resultHome == null) {
            resultHome = new Result(1, 0, 0, 0, match.getTournament().getSeason(), match.getHomeTeam());
        } else {
            // Increment the nb of played match
            resultHome.setPlayed(resultHome.getPlayed() + 1);
        }

        // Search for a result entry with this season and the away/road team

        Result resultAway = resultRepository.findBySeasonAndTeam(match.getTournament().getSeason(), match.getAwayTeam());
        if (resultAway == null) {
            resultAway = new Result(1, 0, 0, 0, match.getTournament().getSeason(), match.getAwayTeam());
        } else {
            // Increment the nb of played match
            resultAway.setPlayed(resultAway.getPlayed() + 1);
        }

        // Draft
        if (match.getHomeTeamScore() == match.getAwayTeamScore()) {
            resultHome.setDraft(resultHome.getDraft() + SCORING_PTS_DRAFT * pts);
            resultAway.setDraft(resultAway.getDraft() + SCORING_PTS_DRAFT * pts);
        }
        // Home team win / Away team loss
        else if (match.getHomeTeamScore() > match.getAwayTeamScore()) {
            resultHome.setWin(resultHome.getWin() + SCORING_PTS_WIN  * pts);
            resultAway.setLoss(resultAway.getLoss() + SCORING_PTS_LOSS * pts);
        }
        // Home team loss / Awat team win
        else {
            resultHome.setLoss(resultHome.getLoss() + SCORING_PTS_LOSS * pts);
            resultAway.setWin(resultAway.getWin() + SCORING_PTS_WIN  * pts);
        }
    }

}
