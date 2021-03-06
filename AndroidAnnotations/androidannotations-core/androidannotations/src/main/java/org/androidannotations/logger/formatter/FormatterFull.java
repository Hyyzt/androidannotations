/**
 * Copyright (C) 2010-2016 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.logger.formatter;

import org.androidannotations.logger.Level;

public class FormatterFull extends Formatter {

	@Override
	public String buildLog(Level level, String loggerName, String message, Throwable thr, Object... args) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(getTime()) //
				.append(" [").append(getCurrentThread()).append("]") //
				.append(" ").append(level.name) //
				.append(" ").append(loggerName) //
				.append(":").append(getCallerLineNumber()) //
				.append(" - ").append(buildFullMessage(message, args));

		// Stacktrace
		if (thr != null) {
			stringBuilder.append('\n').append(stackTraceToString(thr));
		}

		return stringBuilder.toString();
	}

}
