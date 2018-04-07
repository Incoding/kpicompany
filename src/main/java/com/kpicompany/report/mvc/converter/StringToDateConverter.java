package com.kpicompany.report.mvc.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * -------------------------------------------
 * |   @author      |               |
 * -------------------------------------------
 * |    @date       |18/3/18 上午10:44          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 * string 转 java.util.Date
 */
public class StringToDateConverter implements Converter<String, Date> {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private Locale locale;
    private String[] patterns;

    public StringToDateConverter(String[] patterns) {
        this.locale = Locale.CHINA;
        this.patterns = patterns;
    }

    @Override
    public Date convert(String s) {
        if(StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return DateUtils.parseDate(s, this.locale, this.patterns);
            } catch (ParseException var3) {
                this.LOGGER.warn("convert String to Date fail.", var3);
                return null;
            }
        }
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
