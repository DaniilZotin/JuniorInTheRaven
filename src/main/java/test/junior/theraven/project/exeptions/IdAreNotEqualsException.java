package test.junior.theraven.project.exeptions;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.Serial;

/**
 * An exception class that indicates that a requested user was not found.
 * This class extends from the {@link ChangeSetPersister.NotFoundException} class.
 */
public class IdAreNotEqualsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7508454331267540093L;


    public IdAreNotEqualsException(String msg) {
        super(msg);
    }
}
