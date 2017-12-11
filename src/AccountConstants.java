

/**
 * /** Created by errornosignal on 12/08/2017.
 * Constants Interface for ATM
 * @author Reid Nolan
 * @since 12/08/2017
 * @version 1.0
 */
public interface AccountConstants
{
    //declare interface variables
    int kPIN_SIZE = 4;
    int kBALANCE_SIZE = 10;
    int kNUMBER_SIZE = 12;

    /**
     * gets kPIN_SIZE
     * @return kPIN_SIZE
     */
    static int get_kPIN_SIZE()
    {
        return kPIN_SIZE;
    }

    /**
     * gets kBALANCE_SIZE
     * @return kBALANCE_SIZE
     */
    static int get_kBALANCE_SIZE()
    {
        return kBALANCE_SIZE;
    }

    /**
     * gets kNUMBER_SIZE
     * @return kNUMBER_SIZE
     */
    static int get_kNUMBER_SIZE()
    {
        return kNUMBER_SIZE;
    }


}
