package gde.expedienteapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpedienteService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> buscarExpediente(Integer anio, Integer numero, String codigo, int page, int size) {

        StringBuilder sql = new StringBuilder("""
        SELECT 1+ed.POSICION,
        'EX-' || ee.anio || '-' || ee.numero || '-' || ee.CODIGO_REPARTICION_ACTUACION || '-' ||
        ee.CODIGO_REPARTICION_USUARIO AS expediente,
        gd.numero,
        d.MOTIVO,
        d.FECHA_ASOCIACION,
        d.FECHA_CREACION
        FROM ee_ged.ee_expediente_electronico ee
        LEFT JOIN ee_ged.EE_EXPEDIENTE_DOCUMENTOS ed ON ee.id = ed.id
        LEFT JOIN ee_ged.documento d ON ed.ID_DOCUMENTO = d.id
        LEFT JOIN gedo_ged.gedo_documento gd ON d.numero_sade = gd.numero
        WHERE 1=1
        """);

        List<Object> params = new ArrayList<>();
        sql.append(" AND ee.ES_RESERVADO <> 1");

        if (anio != null) {
            sql.append(" AND ee.anio = ?");
            params.add(anio);
        }
        if (numero != null) {
            sql.append(" AND ee.numero = ?");
            params.add(numero);
        }
        if (codigo != null && !codigo.isBlank()) {
            sql.append(" AND ee.CODIGO_REPARTICION_ACTUACION = ?");
            params.add(codigo);
        }
        sql.append(" ORDER BY d.FECHA_CREACION DESC");
        sql.append(" OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        params.add(page * size);
        params.add(size);

        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }
}