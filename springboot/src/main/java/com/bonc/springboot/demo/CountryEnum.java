package com.bonc.springboot.demo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/5 17:05
 */
public enum  CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕");
    //这里可以是 ONE(1,V1,V2,V3,....)多个属性

    private Integer  retCode;
    private String  counTryName;

    CountryEnum(Integer retCode, String counTryName) {
        this.retCode = retCode;
        this.counTryName = counTryName;
    }
    public Integer getRetCode() {
        return retCode;
    }
    public String getCounTryName() {
        return counTryName;
    }

    public static CountryEnum forEachCountry(int index){
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum:countryEnums) {
            if(countryEnum.getRetCode()==index){
                return countryEnum;
            }
        }
        return  null;
    }
}
