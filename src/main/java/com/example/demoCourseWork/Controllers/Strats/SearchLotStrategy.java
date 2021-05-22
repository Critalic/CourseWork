package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Services.LotService;

public class SearchLotStrategy extends SomeStrat{
    LotService lotService;
    public SearchLotStrategy(LotService lotService) {
        this.lotService = lotService;
    }


}
