package coachMe.com.CoachMe.Utilities

class Constants {
    companion object{
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //Base API endpoint for users
        const val URL_BASE_USERS = "$URL_BASE/users"
    }
}