#!/usr/bin/env bash
mvn clean package
STORMPATH_API_KEY_FILE=~/.stormpath/apiKey-3QO3FGPBQKNZL4J28ATUWD84J.properties \
STORMPATH_APPLICATION_HREF=https://api.stormpath.com/v1/applications/4G7yLyQNS7H91r6m1jccN7 \
STORMPATH_AUTHORIZED_GROUP_ADMIN=https://api.stormpath.com/v1/groups/gKuyppB2Vx0JsFnC3fu6r \
STORMPATH_AUTHORIZED_GROUP_USERS=https://api.stormpath.com/v1/groups/6DzXxikUPhQLANUft01iZl \
mvn spring-boot:run