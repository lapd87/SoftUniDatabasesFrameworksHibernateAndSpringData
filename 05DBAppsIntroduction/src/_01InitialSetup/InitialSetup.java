package _01InitialSetup;
/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.3.2018 г.
 * Time: 20:58 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Connector.Connector.getConnection;
import static Connector.Connector.initMySQLLocalConnection;

public class InitialSetup {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("");

        conn = getConnection();

        List<String> workbench = new ArrayList<>();
        workbench.add("DROP DATABASE IF EXISTS `MinionsDB`;");

        prstmt = conn.prepareStatement(workbench.get(0));
        prstmt.executeUpdate();

        prstmt.close();
        conn.close();

        workbench.remove(0);

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        workbench.add("USE `minionsDB`;");
        workbench.add("CREATE TABLE IF NOT EXISTS `minions` (\n" +
                "    `id` INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    `name` VARCHAR(50),\n" +
                "    `age` INT(3),\n" +
                "    `town_id` INT\n" +
                ");");
        workbench.add("CREATE TABLE IF NOT EXISTS `towns` (\n" +
                "    `id` INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    `name` VARCHAR(50),\n" +
                "    `country_id` INT\n" +
                ");");
        workbench.add("CREATE TABLE IF NOT EXISTS `countries` (\n" +
                "    `id` INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    `name` VARCHAR(50)\n" +
                ");");
        workbench.add("CREATE TABLE IF NOT EXISTS `villains` (\n" +
                "    `id` INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    `name` VARCHAR(50),\n" +
                "    `evilness_factor` ENUM('good', 'bad', 'evil', 'super evil')\n" +
                ");");
        workbench.add("CREATE TABLE IF NOT EXISTS `villains_minions` (\n" +
                "    `villain_id` INT,\n" +
                "    `minion_id` INT\n" +
                ");");
        workbench.add("ALTER TABLE `towns`\n" +
                "\tADD CONSTRAINT `FK_towns_countries` \n" +
                "\t\tFOREIGN KEY (`country_id`) \n" +
                "\t\t\tREFERENCES `countries`(`id`);");
        workbench.add("ALTER TABLE `minions`\n" +
                "\tADD CONSTRAINT `FK_minions_towns` \n" +
                "\t\tFOREIGN KEY (`town_id`) \n" +
                "\t\t\tREFERENCES `towns`(`id`);");
        workbench.add("ALTER TABLE `villains_minions`\n" +
                "\tADD CONSTRAINT `PK_villains_minions`\n" +
                "\t\tPRIMARY KEY (`villain_id`,`minion_id`),\n" +
                "\tADD CONSTRAINT `FK_villains_id` \n" +
                "\t\tFOREIGN KEY (`villain_id`) \n" +
                "\t\t\tREFERENCES `villains`(`id`),\n" +
                "\tADD CONSTRAINT  `FK_minions_id`\n" +
                "\t\tFOREIGN KEY (`minion_id`)\n" +
                "\t\t\tREFERENCES `minions`(`id`);");
        workbench.add("INSERT INTO `countries` (`name`)\n" +
                "\tVALUES ('UNKNOWN'),\n" +
                "\t\t('Bulgaria'),\n" +
                "\t\t('Romania'),\n" +
                "\t\t('Serbia'),\n" +
                "\t\t('Greece'),\n" +
                "\t\t('Macedonia'),\n" +
                "\t\t('Turkey');");
        workbench.add("INSERT INTO `towns` (`name`, `country_id`)\n" +
                "\tVALUES ('Sofia',2),\n" +
                "\t\t('Varna',2),\n" +
                "\t\t('Belgrade',4),\n" +
                "\t\t('Athens',5),\n" +
                "\t\t('Skopie',6),\n" +
                "\t\t('Ankara',7),\n" +
                "\t\t('Guirgui',3);");
        workbench.add("INSERT INTO `minions` (`name`, `age`,`town_id`)\n" +
                "\tVALUES ('Bob',13,1),\n" +
                "\t\t('John',123,7),\n" +
                "\t\t('Seb',34,5),\n" +
                "\t\t('Coco',3,3),\n" +
                "\t\t('Karie',21,2),\n" +
                "\t\t('Moni',56,4),\n" +
                "\t\t('Pesho',457,1);");
        workbench.add("INSERT INTO `villains` (`name`, `evilness_factor`)\n" +
                "\tVALUES ('BobE',1),\n" +
                "\t\t('JohnE',2),\n" +
                "\t\t('SebE',1),\n" +
                "\t\t('CocoE',3),\n" +
                "\t\t('KarieE',2),\n" +
                "\t\t('MoniE',4),\n" +
                "\t\t('PeshoE',1);");
        workbench.add("INSERT INTO `villains_minions`\n" +
                "\tVALUES (1,1),\n" +
                "\t\t(2,2),\n" +
                "\t\t(3,1),\n" +
                "\t\t(1,3),\n" +
                "\t\t(1,2),\n" +
                "\t\t(1,4),\n" +
                "\t\t(7,1);");

        for (String sql : workbench) {
            prstmt = conn.prepareStatement(sql);
            prstmt.executeUpdate();
        }

        prstmt.close();
        conn.close();
    }
}