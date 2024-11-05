package ru.itmo.loveconnect.entity.enums;

public enum SocialNetworkType {

    TG("https://t.me/%s"),
    VK("https://vk.com/%s");

    private final String linkFormat;

    SocialNetworkType(final String linkFormat) {
        this.linkFormat = linkFormat;
    }

    public String getFullLink(final String profileId) {
        return String.format(linkFormat, profileId);
    }
}
