import java.util.Objects;

public class Email
{
  private String user;
  private String host;
  private String domain;

  public Email(String user, String host, String domain)
  {
    this.user = user;
    this.host = host;
    this.domain = domain;
  }

  public String getUser()
  {
    return user;
  }

  public String getHost()
  {
    return host;
  }

  public String getDomain()
  {
    return domain;
  }

  public String toString()
  {
    return "kundes email er: " + user + "@" + host + "." + domain;
  }

  @Override public boolean equals(Object object)
  {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    Email email = (Email) object;
    return user.equals(email.user) && host.equals(email.host) && domain.equals(email.domain);
  }
}
