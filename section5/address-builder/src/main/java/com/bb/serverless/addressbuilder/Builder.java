package com.bb.serverless.addressbuilder;

import org.apache.commons.lang3.StringUtils;

public class Builder {

    private static final String ADDRESS_FORMAT = "";

    public void execute(Address address) {
        if (address == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (StringUtils.isNotBlank(address.getStreetNumber())) {
            stringBuilder.append(address.getStreetNumber());
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(StringUtils.SPACE);
        }
        if (StringUtils.isNotBlank(address.getAddressLineOne())) {
            stringBuilder.append(address.getAddressLineOne());
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(System.lineSeparator());
        }
        if (StringUtils.isNotBlank(address.getAddressLineTwo())) {
            stringBuilder.append(address.getAddressLineTwo());
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(System.lineSeparator());
        }
        if (StringUtils.isNotBlank(address.getCity())) {
            stringBuilder.append(address.getCity());
        }
        if (StringUtils.isNotBlank(address.getState())) {
            stringBuilder.append(StringUtils.SPACE);
            stringBuilder.append(address.getState());
        }
        if (StringUtils.isNotBlank(address.getZip())) {
            stringBuilder.append(StringUtils.SPACE);
            stringBuilder.append(address.getZip());
        }
        address.setFullAddress(stringBuilder.toString());
    }
}
