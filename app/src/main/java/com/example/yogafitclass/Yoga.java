package com.example.yogafitclass;

public class Yoga {


        int logo;
        String name;
        String words;
        String link;

        public Yoga(int logo, String name, String words, String link) {
            this.logo = logo;
            this.name = name;
            this.words = words;
            this.link = link;
        }

        public int getLogo() {
            return logo;
        }

        public void setLogo(int logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }



        public String getLink() { return link; }

        public void setLink(String link) {
            this.link = link;
        }


        @Override
        public String toString() {
            return "Potter{" +
                    "logo=" + logo +
                    ", name=" + name +
                    ", words=" + words +
                    ", link=" + link +
                    '}';
        }
    }

