public class ProtectUserPassword {

        public static String encryptPassword(String myPassword)
        {
            // Generate Salt. The generated value can be stored in DB.
            String salt = PasswordUtils.getSalt(30);

            // Protect user's password. The generated value can be stored in DB.

            // Print out protected password
//            System.out.println("My secure password = " + mySecurePassword);
//            System.out.println("Salt value = " + salt);
            return PasswordUtils.generateSecurePassword(myPassword, salt);
        }
}