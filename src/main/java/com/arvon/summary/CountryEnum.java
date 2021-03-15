package com.arvon.summary;

import lombok.Data;
import lombok.Getter;

/**
 * @author Arvon
 * @date 2021/3/15 18:16
 */
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "赵"),
    FOUR(4, "魏"),
    FIVE(5, "燕"),
    SIX(6, "韩");

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private Integer code;
    private String msg;

    CountryEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CountryEnum getForEachCountry(Integer index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (index.equals(countryEnum.getCode())) {
                return countryEnum;
            }
        }
        return null;
    }
}
