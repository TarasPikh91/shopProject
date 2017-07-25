package com.shop.serviceImpl;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by taras on 6/21/2017.
 */
public class CookiesThenAcceptHendlerLocalResolver extends CookieLocaleResolver {


    private final AcceptHeaderLocaleResolver acceptHeaderLocaleResolver =
            new AcceptHeaderLocaleResolver();

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest request) {

        Locale currentLocal =
                new Locale(acceptHeaderLocaleResolver
                        .resolveLocale(request)
                        .getLanguage());

        if(currentLocal.equals("ua")) return new Locale("ua");


        return new Locale("en");
    }
}