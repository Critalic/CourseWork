package com.example.demoCourseWork.Controllers;

import com.example.demoCourseWork.Controllers.Strats.SignUpStrategy;
import com.example.demoCourseWork.Controllers.Strats.SomeStrat;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.Services.UserService;

public class StrategySelector {
    private UserService userService;
    private LotService lotService;

    public StrategySelector(UserService userService, LotService lotService) {
        this.userService = userService;
        this.lotService = lotService;
    }

    public SomeStrat getStrategy (String path) {
        switch (path) {
            case "/login":
                return new LoginProcessRequestDecorator(userService);
            case "/signup":
                return new SignUpStrategy(userService);
            case "/createLot":
            case "/newTender":
                return new TenderCreateProcessRequestDecorator(lotService);
            case "/createOffer":
            case "/newOffer":
                return new OfferCreateProcessRequestDecorator(lotService);
            case "/logout":
                return new LogOutProcessRequestDecorator();
            case "/setStatus":
                return new SetStatusProcessRequestDecorator(lotService);
            case "/search":
                return new TenderWithNameProcessRequestDecorator(lotService);
            case "/deleteLot":
                return new DeleteProcessRequestDecorator(lotService);
            case "/lot":
                return new TenderWithIdProcessRequestDecorator(lotService);
            default:
                return new TenderListProcessRequestDecorator(lotService);
        }
    }
}
