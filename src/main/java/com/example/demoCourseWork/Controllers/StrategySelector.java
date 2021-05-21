package com.example.demoCourseWork.Controllers;

import com.example.demoCourseWork.Controllers.Strats.*;
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
            case "/logIn":
                return new LogInStrategy(userService);
            case "/signUp":
                return new SignUpStrategy(userService);
            case "/createLot":
                return new NewLotStrategy(lotService);
            case "/mainPage":
                return new MainPageStrategy(lotService);
            case "/viewLot":
                return new ViewLotStrategy(lotService);
            case "/editLot":
                return new LotEditingStrategy(lotService);
            case "/logOut":
                return new LogOutStrategy(userService, lotService);
//            case "/setStatus":
//                return new SetStatusProcessRequestDecorator(lotService);
//            case "/search":
//                return new TenderWithNameProcessRequestDecorator(lotService);
//            case "/deleteLot":
//                return new DeleteProcessRequestDecorator(lotService);
            case "/makeOffer":
                return new MakeOfferStrategy(lotService);
            default:
                return new ShowLotsStrategy(lotService);
        }
    }
}
