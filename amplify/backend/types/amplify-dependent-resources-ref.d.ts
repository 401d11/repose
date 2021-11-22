export type AmplifyDependentResourcesAttributes = {
    "api": {
        "amplifyDatasource": {
            "GraphQLAPIIdOutput": "string",
            "GraphQLAPIEndpointOutput": "string"
        }
    },
    "auth": {
        "reposede282bc0": {
            "IdentityPoolId": "string",
            "IdentityPoolName": "string",
            "UserPoolId": "string",
            "UserPoolArn": "string",
            "UserPoolName": "string",
            "AppClientIDWeb": "string",
            "AppClientID": "string"
        }
    },
    "storage": {
        "reposestorage": {
            "BucketName": "string",
            "Region": "string"
        }
    },
    "predictions": {
        "stretchSpeechGenerator": {
            "region": "string",
            "language": "string",
            "voice": "string"
        }
    }
}