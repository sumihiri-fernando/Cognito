package se.sumihiri.spring_my_application_cognito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import se.sumihiri.spring_my_application_cognito.models.User;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListUsersRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListUsersResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.UserType;

public class UserService {
    @Autowired
    private CognitoIdentityProviderClient cognitoIdentityProviderClient;

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        ListUsersRequest listUsersRequest = ListUsersRequest.builder()
                .userPoolId("eu-north-1_pMjGBAMHh")
                .build();

        ListUsersResponse listUsersResponse = cognitoIdentityProviderClient.listUsers(listUsersRequest);

        for (UserType userType : listUsersResponse.users()) {
            String username = userType.username();
            String email = null;
            // You may need to adjust this according to your user attributes
            for (software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType attribute : userType
                    .attributes()) {
                if (attribute.name().equals("email")) {
                    email = attribute.value();
                    break;
                }
            }
            userList.add(new User(username, email));
        }

        return userList;
    }
}
