/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author itdev4
 */
public class CookieHelper {

  public void setCookie(String name, String value, int expiry) {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    Cookie cookie = null;

    Cookie[] userCookies = request.getCookies();
    if (userCookies != null && userCookies.length > 0 ) {
        for (int i = 0; i < userCookies.length; i++) {
            if (userCookies[i].getName().equals(name)) {
                cookie = userCookies[i];
                break;
            }
        }
    }

    if (cookie != null) {
        cookie.setValue(value);
    } else {
        cookie = new Cookie(name, value);
        cookie.setPath(request.getContextPath());
    }

    cookie.setMaxAge(expiry);

    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
    response.addCookie(cookie);
  }

  public Cookie getCookie(String name) {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    Cookie cookie = null;

    Cookie[] userCookies = request.getCookies();
    if (userCookies != null && userCookies.length > 0 ) {
        for (int i = 0; i < userCookies.length; i++) {
            if (userCookies[i].getName().equals(name)) {
                cookie = userCookies[i];
                return cookie;
            }
        }
    }
    return null;
  }
}
//
//to set cookies
//String name = "cookiename";
//String value = "cookievalue";
//Map<String, Object> properties = new HashMap<>();
//properties.put("maxAge", 31536000);
//properties.put("path", "/");
//externalContext.addResponseCookie(name, URLEncoder.encode(value, "UTF-8"), properties);

//Cookie cookie = (Cookie) externalContext.getRequestCookieMap().get(name);
//String value = URLDecoder.decode(cookie.getValue(), "UTF-8");