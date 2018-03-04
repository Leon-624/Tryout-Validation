package org.liyanxu.tryout.validation.api;

import org.liyanxu.tryout.validation.api.model.Person;

public interface PersonalInfoApi {

    void setPerson(Person person);

    void setPersonNotNull(Person person);

}
