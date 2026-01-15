package CurrentDateClassInJava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = formatter.format(localDate);
        System.out.println(date);

        System.out.println("===============");

        LocalDate plusDecades = localDate.plus(50, ChronoUnit.DECADES); // adicionando decadas
        String datePlusDecades = formatter.format(plusDecades); // formatando
        System.out.println(datePlusDecades);

        System.out.println("===============");

        LocalDate minDecades = localDate.minus(50, ChronoUnit.DECADES); // removendo decadas
        String dateMinDecades = formatter.format(minDecades); // formatando
        System.out.println(dateMinDecades);

        System.out.println("===============");

        System.out.println("Dia do ano: "  + localDate.getDayOfYear());

        System.out.println("===============");

        //localDate.isEqual(); esse método serve para trabalhar com datas de outros países, como por exemplo o calendário Japonês


        LocalTime localTime = LocalTime.now();
//        System.out.println(localTime);
        //DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime); // estou formatando para ISO, é uma das formas que podemos usar em APIs modernas
        //System.out.println(timeFormatter.format(localTime));
        System.out.println(localTime.withHour(22)); // podemos setar a hora que quisermos


        System.out.println("===============");

        // uma das maneiras de fazer uma conversão para a versão mais atual

        Date date1 = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        ZoneId zoneId = calendar1.getTimeZone().toZoneId();
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(calendar1.toInstant(), zoneId);

        System.out.println(localDateTime1);

        System.out.println("===============");

        Date dateTimeZone = Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(-3))); // conseguimos usar esse método para fazer migração de código legado para uma versão mais atual
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        System.out.println(dateTimeZone);

        System.out.println("===============");

        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println(offsetDateTime);

        System.out.println("===============");

        OffsetDateTime offsetDateTimeUTC = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC); // convertendo para utc

        System.out.println(offsetDateTimeUTC);

        System.out.println("===============");

        System.out.println(offsetDateTime.isEqual(offsetDateTimeUTC)); // retornou TRUE, pois as datas ocorrem no mesmo instante independente do horário




    }






}
