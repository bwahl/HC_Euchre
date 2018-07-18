import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubSub {
  private static PubSub ourInstance = new PubSub();
  public static PubSub getInstance() {
    return ourInstance;
  }

  // Instance Variable
  public Map<EuchreEvent.Topic, List<Subscriber>> subscribers = new HashMap<>();

  private PubSub() {
    initializeSubscribers();
  }

  private void initializeSubscribers() {
    for (EuchreEvent.Topic topic : EuchreEvent.Topic.values()) {
      subscribers.put(topic, new ArrayList<>());
    }
  }

  void subscribe(EuchreEvent.Topic topic, Subscriber subscriber) {
    List<Subscriber> topicSubscribers = subscribers.get(topic);
    if (!topicSubscribers.contains(subscriber)) {
      topicSubscribers.add(subscriber);
    }
  }

  void unsubscribe(EuchreEvent.Topic topic, Subscriber subscriber) {
    List<Subscriber> topicSubscribers = subscribers.get(topic);
    topicSubscribers.remove(subscriber);
  }

  void publish(EuchreEvent event) {
    for (Subscriber subscriber : subscribers.get(event.getTopic())) {
      subscriber.respond(event);
    }
  }
}
