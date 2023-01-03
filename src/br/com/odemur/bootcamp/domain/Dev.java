package br.com.odemur.bootcamp.domain;

import java.util.*;

public class Dev {
    private String name;
    private Set<Content> startedContent = new LinkedHashSet<>();
    private Set<Content> endedContent = new LinkedHashSet<>();

    public void subscribeBootcamp(Bootcamp bootcamp){
        this.startedContent.addAll(bootcamp.getContents());
        bootcamp.getMembers().add(this);
    }

    public void progress() {
        Optional<Content> conteudo = this.startedContent.stream().findFirst();
        if(conteudo.isPresent()) {
            this.endedContent.add(conteudo.get());
            this.startedContent.remove(conteudo.get());
        } else {
            System.err.println("Content subscription not found.");
        }
    }

    public double calculateXP() {
        Iterator<Content> iterator = this.endedContent.iterator();
        double sum = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calculateXP();
            sum += next;
        }
        return sum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getStartedContent() {
        return startedContent;
    }

    public void setStartedContent(Set<Content> startedContent) {
        this.startedContent = startedContent;
    }

    public Set<Content> getEndedContent() {
        return endedContent;
    }

    public void setEndedContent(Set<Content> endedContent) {
        this.endedContent = endedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(startedContent, dev.startedContent) && Objects.equals(endedContent, dev.endedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startedContent, endedContent);
    }
}
