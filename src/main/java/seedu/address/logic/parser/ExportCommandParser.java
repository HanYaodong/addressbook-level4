package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 *
 */
public class ExportCommandParser implements Parser<ExportCommand> {

    private static final Pattern INDEXES_AND_FILEPATH =
        Pattern.compile("(?<indexesString>.(((\\d)*(,)*(\\s)*)+));(?<filePath>.*)");

    @Override
    public ExportCommand parse(String args) throws ParseException {
        final Matcher matcher = INDEXES_AND_FILEPATH.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));
        }
        final String indexesString = matcher.group("indexesString");
        final String filePath = matcher.group("filePath").trim();

        // parse indexes
        List<Index> indexes;
        try {
            indexes = ParserUtil.parserIndexList(indexesString);
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));
        }

        // check filePath
        if (filePath.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, "Missing file path!\n" + ExportCommand.MESSAGE_USAGE));
        }

        return new ExportCommand(indexes, filePath);
    }
}
