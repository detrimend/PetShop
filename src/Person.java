public abstract class Person
{
  private Name name;
  private Email email;

  public Person(Name name, Email email)
  {
    setName(name);
    setEmail(email);
  }

  public Name getName()
  {
    return name;
  }
  public Email getEmail()
  {
    return email;
  }
  public void setName(Name name)
  {
    this.name = name;
  }
  public void setEmail(Email email)
  {
    this.email = email;
  }

   public String toString()
  {
    return "kundens navn er: " + name + "\n" + "kunden email er: " + email ;
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if(obj == null || getClass() != obj.getClass())
      return false;
    Person person = (Person) obj;
    return name.equals(person.name) && email.equals((person.email));
  }
}
