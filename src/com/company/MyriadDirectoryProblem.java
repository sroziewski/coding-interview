package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class MyriadDirectoryProblem {

    private static String userInput(){
        String inputString;
        do{
            System. out. print("Enter directory: ");
            Scanner input = new Scanner(System.in);
            inputString = input.nextLine();
        }
        while (!validateDir(inputString));
        return inputString;
    }

    private static boolean validateDir(String dir){
        boolean validated = Files.exists(Paths.get(dir), LinkOption.NOFOLLOW_LINKS);
        if(dir.length()==0)validated = false;
        if(!validated)
            System. out. println("You have entered not a valid directory");
        return validated;
    }

    @SuppressWarnings("unchecked")
    private static <T extends FileVisitor>T getFilesFromDirectory(String userDir, int depth, T visitor){
        try {
            Files.walkFileTree(Paths.get(userDir), new HashSet<>(), depth, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitor;
    }

    static private class  FirstLevelVisitor implements FileVisitor<Path> {
        private List<String> dirs = new ArrayList<>();
        private Map<String, Long> files = new HashMap<>();

        @Override
        public FileVisitResult visitFile(Path path , BasicFileAttributes attrs) {
            File file = path.toFile();
            if(file.isDirectory()){
                dirs.add(file.getAbsolutePath());
            }
            if(file.isFile()){
                files.put(file.getAbsolutePath(), file.length());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path path , IOException e) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path , BasicFileAttributes attrs) {
            return FileVisitResult.CONTINUE;
        }

        List<String> getDirs() {
            return dirs;
        }

        Map<String, Long> getFiles() {
            return files;
        }
    }

    static private class  HigherLevelVisitor implements FileVisitor<Path> {
        private long weight;

        @Override
        public FileVisitResult visitFile(Path path , BasicFileAttributes attrs) {
            File file = path.toFile();
            if(file.isFile()){
                weight += file.length();
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path path , IOException e) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path , BasicFileAttributes attrs) {
            return FileVisitResult.CONTINUE;
        }

        long getWeight() {
            return weight;
        }

    }

    private static String getAsKb(Long value){
        return String.format("%s %s", String.valueOf(Math.round(value/1024.0 * 100.0) / 100.0), "KB");
    }

    public static void main(String[] args) {
        String userDir = userInput();
        FirstLevelVisitor firstLevelVisitor = new FirstLevelVisitor();
        getFilesFromDirectory(userDir, 1, firstLevelVisitor);
        List<String> dirsFirstLevel = firstLevelVisitor.getDirs();
        Map<String, Long> filesFirstLevel = firstLevelVisitor.getFiles();
        Map<String, Long> dirsWeights = dirsFirstLevel.stream().map(dir -> new AbstractMap.SimpleEntry<>(dir, getFilesFromDirectory(dir, Integer.MAX_VALUE, new HigherLevelVisitor()).getWeight()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Map.Entry<String, String>, Long> filesMap = filesFirstLevel.entrySet().stream().map(entry -> new AbstractMap.SimpleEntry<>(Map.entry("FILE", entry.getKey()), entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Map.Entry<String, String>, Long> dirsMap = dirsWeights.entrySet().stream().map(entry -> new AbstractMap.SimpleEntry<>(Map.entry("DIR", entry.getKey()), entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filesMap.putAll(dirsMap);
        Map<Map.Entry<String, String>, Long> finalMap = filesMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        finalMap.forEach((key, value) -> System.out.println(String.format("%s %s %s", key.getKey(), key.getValue(), getAsKb(value))));
    }

}
