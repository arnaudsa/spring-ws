/*
 * Copyright 2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.endpoint.interceptor;

import javax.xml.transform.Source;

import org.springframework.ws.WebServiceMessage;

/**
 * Interceptor that validates the contents of <code>WebServiceMessage</code>s using a schema. Allows for both W3C XML
 * and RELAX NG schemas.
 * <p/>
 * When the payload is invalid, this interceptor stops processing of the interceptor chain. Additionally, if the message
 * is a SOAP request message, a SOAP Fault is created as reply. Invalid SOAP responses do not result in a fault.
 * <p/>
 * The schema to validate against is set with the <code>schema</code> property. By default, only the request message is
 * validated, but this behaviour can be changed using the <code>validateRequest</code> and <code>validateResponse</code>
 * properties. Responses that contains faults are not validated.
 *
 * @author Arjen Poutsma
 * @see #setSchema
 * @see #setValidateRequest(boolean)
 * @see #setValidateResponse(boolean)
 */
public class PayloadValidatingInterceptor extends AbstractValidatingInterceptor {

    /**
     * Returns the payload source of the given message.
     */
    protected Source getValidationRequestSource(WebServiceMessage request) {
        return request.getPayloadSource();
    }

    /**
     * Returns the payload source of the given message.
     */
    protected Source getValidationResponseSource(WebServiceMessage response) {
        return response.getPayloadSource();
    }
}
