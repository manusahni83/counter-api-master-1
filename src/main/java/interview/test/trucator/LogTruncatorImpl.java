package interview.test.trucator;

public class LogTruncatorImpl implements LogTruncator {

    @Override
    public String truncate(String log, int length) {
        String replaceChars = " ... (truncated) ... ";
        if (log.length() < length || log.length() < replaceChars.length() || length < replaceChars.length()) {
            return log;
        }

        int diff1 = (int) ((log.length() + 1 - length) / 2);

        StringBuilder firstHalf = new StringBuilder(log.substring(0, (log.length() / 2) - ((replaceChars.length() / 2) + (diff1))));

        StringBuilder secondHalf = new StringBuilder(log.substring(log.length() / 2 + replaceChars.length() / 2 + (log.length() - length) / 2 + 1));

        return firstHalf.append(replaceChars).append(secondHalf).toString();

    }

    // Just for test. In actual project, would have used junit
    public static void main(String args[]) {
        LogTruncatorImpl impl = new LogTruncatorImpl();
        System.out.println(impl.truncate("123456789012345678901234567890", 25));
        System.out.println(impl.truncate("1234567890123456789012345678901", 25));
        System.out.println(impl.truncate("1234567890", 5));
        System.out.println(impl.truncate("123456789012345678901234567890", 31));
    }

}
