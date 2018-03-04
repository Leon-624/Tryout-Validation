package org.liyanxu.tryout.validation.service;

import lombok.NonNull;
import org.liyanxu.tryout.validation.api.PersonalInfoApi;
import org.liyanxu.tryout.validation.api.model.Person;
import javax.inject.Inject;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Optional;

public class PersonalInfoApiImpl implements PersonalInfoApi {

    private final Optional<Validator> validator;

    public PersonalInfoApiImpl() {
        validator = Optional.empty();
    }

    @Inject
    public PersonalInfoApiImpl(Validator validator) {
        this.validator = Optional.ofNullable(validator);
    }

    @Override
    public void setPerson(Person person) {
        validateArg(person);
        System.out.println(person);
    }

    @Override
    public void setPersonNotNull(@NonNull Person person) {
        validateArg(person);
        System.out.println(person);
    }

    private void validateArg(Object... objects) {
        Arrays.stream(objects).parallel().forEach(object -> {
            if(object != null) {
                validator.map(v -> v.validate(object)).ifPresent(errors -> {
                    if(!errors.isEmpty()) {
                        throw new IllegalArgumentException(object.getClass().getName());
                    }
                });
            }
        });
    }
}
