package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;

/**
 * Adds a remark to a person by INDEX
 */
public class RemarkCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "remark";
    public static final String COMMAND_ALIAS = "rmk";

    private final Index targetIndex;

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the remark for a person specified in the INDEX.\n"
            + "Parameters: INDEX (must be a positive integer)" + PREFIX_REMARK + "[REMARK]"
            + "Example: " + COMMAND_WORD + " 1" + PREFIX_REMARK + " Likes to drink coffee";

    public static final String MESSAGE_SUCCESS = "New remark added: %1$s";

    @Override
    protected CommandResult executeUndoableCommand() throws CommandException {
        throw new CommandException("Exception"); // stub exception for the time being
    }

    public RemarkCommand(Index index) {
        targetIndex = index;
    }
}
