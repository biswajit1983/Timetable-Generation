package org.iitk.brihaspati.modules.screens.call;
/*
 * @(#)SecureScreen_Admin.java	
 *
 *  Copyright (c) 2004 ETRG,IIT Kanpur. 
 *  All Rights Reserved.
 *
 *  Redistribution and use in source and binary forms, with or 
 *  without modification, are permitted provided that the following 
 *  conditions are met:
 * 
 *  Redistributions of source code must retain the above copyright  
 *  notice, this  list of conditions and the following disclaimer.
 * 
 *  Redistribution in binary form must reproducuce the above copyright 
 *  notice, this list of conditions and the following disclaimer in 
 *  the documentation and/or other materials provided with the 
 *  distribution.
 * 
 * 
 *  THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED.  IN NO EVENT SHALL ETRG OR ITS CONTRIBUTORS BE LIABLE
 *  FOR ANY DIRECT, INDIRECT, INCIDENTAL,SPECIAL, EXEMPLARY, OR 
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 *  OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
 *  BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 *  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 *  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 *  EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  Contributors: Members of ETRG, I.I.T. Kanpur 
 */  

import org.apache.turbine.modules.screens.VelocitySecureScreen;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.apache.turbine.util.security.AccessControlList;
import org.apache.turbine.Turbine;
/**
 * This class has code of authorized Screens for Admin
 * @author <a href="mailto:awadhk_t@yahoo.com">Awadhesh Kuamr Trivedi</a>
 */
public class SecureScreen_Admin extends VelocitySecureScreen
{
    public void doBuildTemplate(RunData data, Context context)
    {
    }
    /**
     * Check authorization using AccessControlList
     * @param data RunData
     * @param boolean
     */ 
    protected boolean isAuthorized( RunData data )  throws Exception
    {
        boolean isAuthorized = false;
        AccessControlList acl = data.getACL();
	if(acl==null || ! acl.hasRole("turbine_root"))
		{
            		data.setScreenTemplate(Turbine.getConfiguration().getString("template.login"));
            		isAuthorized = false;
		}
	else if(acl.hasRole("turbine_root"))
		{
				isAuthorized=true;
		}
        return isAuthorized;
    }
}
