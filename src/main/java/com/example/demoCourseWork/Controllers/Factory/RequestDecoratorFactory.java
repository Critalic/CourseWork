package com.example.demoCourseWork.Controllers.Factory;

import com.example.demoCourseWork.Controllers.Decorators.*;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.Services.UserService;


public class RequestDecoratorFactory {
    private UserService userService;
    private LotService lotService;

    public RequestDecoratorFactory(UserService userService, LotService tenderService) {
        this.userService = userService;
        this.lotService = tenderService;
    }

    public ProcessRequestDecorator getDecoratorForPath(String path) {
        switch (path) {
            case "/login":
                return new LoginRequestDecorator(userService);
            case "/signup":
                return new SignUpRequestDecorator(userService);
            case "/createTender":
            case "/newTender":
                return new TenderCreateRequestDecorator(lotService);
            case "/createOffer":
            case "/newOffer":
                return new OfferCreateRequestDecorator(lotService);
            case "/logout":
                return new LogOutRequestDecorator();
            case "/setStatus":
                return new SetStatusRequestDecorator(lotService);
            case "/search":
                return new TenderWithNameRequestDecorator(lotService);
            case "/deleteTender":
                return new DeleteRequestDecorator(lotService);
            case "/tender":
                return new TenderWithIdRequestDecorator(lotService);
            default:
                return new LotListRequestDecorator(lotService);
        }
    }
}
