/*
 *     Copyright 2015-2016 Austin Keener & Michael Ritter
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

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class DiscordBot
{
	@SuppressWarnings("unused")
	private static JDA jda;

	/**
	 * This is the method where the program starts.
	 */
	public static void main(String[] args)
	{
		//We construct a builder for a BOT account. If we wanted to use a CLIENT account
		// we would use AccountType.CLIENT
		try
		{
			jda = new JDABuilder(AccountType.BOT)
					.setToken("MjY2MzI3MjA0MjIzMjU0NTI4.C08QqQ.wI0Xmtv24PYpNhHG8Mr13fxYcY8") //The token of the account that is logging in.
					.addListener(new MessageListener())  //An instance of a class that will handle events.
					.addListener(new OnReadyListener())
					.buildBlocking();
		}
		catch (LoginException e)
		{
			//If anything goes wrong in terms of authentication, this is the exception that will represent it
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			//Due to the fact that buildBlocking is a blocking method, one which waits until JDA is fully loaded,
			// the waiting can be interrupted. This is the exception that would fire in that situation.
			//As a note: in this extremely simplified example this will never occur. In fact, this will never occur unless
			// you use buildBlocking in a thread that has the possibility of being interrupted (async thread usage and interrupts)
			e.printStackTrace();
		}
		catch (RateLimitedException e)
		{
			//The login process is one which can be ratelimited. If you attempt to login in multiple times, in rapid succession
			// (multiple times a second), you would hit the ratelimit, and would see this exception.
			//As a note: It is highly unlikely that you will ever see the exception here due to how infrequent login is.
			e.printStackTrace();
		}
	}
}

	