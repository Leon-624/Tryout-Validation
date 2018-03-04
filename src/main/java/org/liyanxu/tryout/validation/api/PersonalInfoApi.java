package org.liyanxu.tryout.validation.api;

import org.liyanxu.tryout.validation.api.model.Person;

public interface PersonalInfoApi {

    void setPerson(Person person);          // person can be null

    void setPersonNotNull(Person person);   // person cannot be null

}
