package se.sumihiri.spring_my_application_cognito.configuration;

import se.sumihiri.spring_my_application_cognito.controller.UserTypeData;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.ArrayList;
import java.util.List;

public class Cognito {

    private static final AwsCredentialsProvider credentialsProvider = DefaultCredentialsProvider.create();

    private static CognitoIdentityProviderClient getClient() {
        return CognitoIdentityProviderClient.builder()
                .region(Region.EU_NORTH_1)
                .credentialsProvider(credentialsProvider)
                .build();
    }

    public static Boolean signUp(String clientId, String username, String password, String email) {
        AttributeType userAttrs = AttributeType.builder()
                .name("email")
                .value(email)
                .build();

        List<AttributeType> userAttrsList = new ArrayList<>();
        userAttrsList.add(userAttrs);
        try {
            SignUpRequest signUpRequest = SignUpRequest.builder()
                    .userAttributes(userAttrsList)
                    .username(username)
                    .clientId(clientId)
                    .password(password)
                    .build();

            getClient().signUp(signUpRequest);
            System.out.println("User has been signed up");

            return true;
        } catch (CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }

        return false;
    }

    public static void confirmUser(String poolId, String username) {
        try {
            AdminConfirmSignUpRequest request = AdminConfirmSignUpRequest.builder()
                    .userPoolId(poolId)
                    .username(username)
                    .build();

            getClient().adminConfirmSignUp(request);
        } catch (CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }

    public static void deleteUser(String userPoolId, String username) {
        try {
            AdminDeleteUserRequest deleteUserRequest = AdminDeleteUserRequest.builder()
                    .userPoolId(userPoolId)
                    .username(username)
                    .build();

            getClient().adminDeleteUser(deleteUserRequest);
            System.out.println("User " + username + " has been deleted from user pool " + userPoolId);
        } catch (CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }

    public static List<UserTypeData> listUsers(String userPoolId) {
        List<UserTypeData> userList = new ArrayList<>();

        try {
            ListUsersRequest listUsersRequest = ListUsersRequest.builder()
                    .userPoolId(userPoolId)
                    .build();

            ListUsersResponse response = getClient().listUsers(listUsersRequest);

            response.users().forEach(user -> {
                UserTypeData userType = new UserTypeData();
                userType.setUsername(user.username());
                user.attributes().forEach(attribute -> {
                    if ("sub".equals(attribute.name())) {
                        userType.setId(attribute.value());
                    }
                });
                userList.add(userType);
            });

        } catch (CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }

        return userList;
    }
}
