/*
 * Copyright (C) 2012 NS Solutions Corporation
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
package com.htmlhifive.sync.resource;

/**
 * リソースアイテムの情報を保持するオブジェクトを、実際の型に変換するコンバータインターフェース.
 *
 * @param <T> リソースアイテムの型
 * @author kishigam
 */
public interface ResourceItemConverter<T> {

	/**
	 * オブジェクトをリソースアイテムの型に変換します.
	 *
	 * @param itemObj リソースアイテムの情報を持つオブジェクト
	 * @param to リソースアイテム型のクラスオブジェクト
	 * @return リソースアイテム型オブジェクト
	 */
	T convert(Object itemObj, Class<T> to);
}