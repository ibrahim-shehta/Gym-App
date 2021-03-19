package com.gym.common.jasper.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class JasperExporterServiceImpl {

	@Autowired
	private DataSource dataSource;

	public void exportPdfToFile(String templatePath, String pdfPath, Map<String, Object> params) {
		JasperPrint print = fillReport(templatePath, params);
		try {
			JasperExportManager.exportReportToPdfFile(print, pdfPath);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public void exportPdfToFileWithCompile(String templatePath, String pdfPath, Map<String, Object> params) {
		Path path = Paths.get(templatePath);
		try {
			final JasperReport report = JasperCompileManager.compileReport(Files.newInputStream(path));
			final JasperPrint print = JasperFillManager.fillReport(report, params, dataSource.getConnection());
			JasperExportManager.exportReportToPdfFile(print, pdfPath);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	private JasperPrint fillReport(String templatePath, Map<String, Object> params) {
		JasperPrint jasperPrint = null;
		Path path = Paths.get(templatePath);
		try {
			JasperReport template = (JasperReport) JRLoader.loadObject(Files.newInputStream(path));
			template.setWhenNoDataType(WhenNoDataTypeEnum.NO_DATA_SECTION);
			jasperPrint = JasperFillManager.fillReport(template, params, dataSource.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jasperPrint;
	}
}
