/*
 * Copyright 2017 Vincenzo De Notaris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package com.asi.security.saml.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asi.security.saml.web.stereotypes.CurrentUser;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class LandingController {

    @Value("${asi.sso.apps.superadmin}")
    private String superadmin;

    @Value("${asi.sso.apps.investorview}")
    private String investorview;

    @RequestMapping("/landing")
	public String landing(@CurrentUser User user, HttpServletRequest request, Model model) {
		model.addAttribute("username", 	user.getUsername());

        // look for the user roles..
        Collection<GrantedAuthority> auth = user.getAuthorities();

        // some functional programming for fun..
        GrantedAuthority role = auth.stream().filter( a -> a.getAuthority().equals("ROLE_USER")).findFirst().orElse(null);

        if (role != null) {
            return investorview;
        }
        else {
            return superadmin;
        }
	}

}
