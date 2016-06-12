/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.util.regexpattern;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.feilong.core.BaseParameterizedTest;
import com.feilong.core.RegexPattern;
import com.feilong.core.util.RegexUtil;

/**
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.5.3
 */
public class EmailPatternTest extends BaseParameterizedTest<String, Boolean>{

    /**
     * Data.
     *
     * @return the collection
     */
    @Parameters(name = "index:{index}: matches({0})={1}")
    public static Iterable<Object[]> data(){
        String[] valids = {
                            "mkyong@yahoo.com",
                            "mkyong-100@yahoo.com",
                            "mkyong.100@yahoo.com",
                            "mkyong111@mkyong.com",
                            "mkyong-100@mkyong.net",
                            "mkyong.100@mkyong.com.au",
                            "mkyong@1.com",
                            "mkyong@gmail.com.com",
                            "mkyong+100@gmail.com",
                            "mkyong-100@yahoo-test.com",
                            "blahblah#3@gmail.com" };

        String[] invalids = {
                              "mkyong",
                              "mkyong@.com.my",
                              "mkyong123@gmail.a",
                              "mkyong123@.com",
                              "mkyong123@.com.com",
                              ".mkyong@mkyong.com",
                              "mkyong()*@gmail.com",
                              "mkyong@%*.com",
                              "mkyong..2002@gmail.com",
                              "mkyong.@gmail.com",
                              "mkyong@mkyong@gmail.com",
                              "mkyong@gmail.com.1a" };

        List<Object[]> list = toList(valids, invalids);
        //list.add(new Object[] { "blahblah#3@gmail.com", true });
        //list.add(new Object[] { "adnamariqq@gmail", false });
        return list;
    }

    /**
     * Checks if is leap year.
     */
    @Test
    public void matches(){
        assertEquals(expectedValue, RegexUtil.matches(RegexPattern.EMAIL, input));

    }

    /**
     * Testenclosing_type.
     */
    //@Test
    public void testenclosing_type(){
        //assertEquals(expectedValue, RegexUtil.matches("^\\s*?(.+)@(.+?)\\s*$", pattern));
        assertEquals(
                        expectedValue,
                        RegexUtil.matches(
                                        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                                        input));
    }
}