/*
 * Copyright (C) 2012-2013 NS Solutions Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.htmlhifive.resourcefw.file.exception;

/**
 * リクエストの対象となるデータが存在しないために実行できない場合にスローされる例外.
 *
 * @author kawaguch
 */
public class TargetNotFoundException extends UrlTreeSystemException {

	private static final long serialVersionUID = 7917108726610076918L;

	public TargetNotFoundException() {
		super();
	}

	public TargetNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TargetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TargetNotFoundException(String message) {
		super(message);
	}

	public TargetNotFoundException(Throwable cause) {
		super(cause);
	}
}