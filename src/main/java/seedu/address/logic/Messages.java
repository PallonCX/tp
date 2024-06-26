package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_WELCOME =
            "Welcome to Dormie!\n"
                    + "The available commands are as follows: list, add, edit, delete, addTime, deleteTime"
                    + ", whoisFree, find, "
                    + "clear, exit\n"
                    + "Refer to the help guide (link can be found above) for more details.";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_NO_FREETIME_SPECIFIED = "Please specify a free time.";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone());

        if (person.getEmail() != null) {
            builder.append("; Email: ").append(person.getEmail());
        }

        if (person.getRoomNumber() != null) {
            builder.append("; Room Number: ").append(person.getRoomNumber());
        }

        if (person.getTelegram() != null) {
            builder.append("; Telegram: ").append(person.getTelegram());
        }

        if (person.getBirthday() != null) {
            builder.append("; Birthday: ").append(person.getBirthday());
        }

        if (person.getDormTag() != null) {
            builder.append("; Dorm Tag: ").append(person.getDormTag());
        }

        if (!person.getTags().isEmpty()) {
            builder.append("; Free Time Tags: ");
            person.getTags().forEach(builder::append);
        }

        return builder.toString();
    }

}
