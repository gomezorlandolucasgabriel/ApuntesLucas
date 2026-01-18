//dtd

<!ELEMENT parking (origen, elaborado, tarifas, plazas, abonados, accesos)>

<!ELEMENT origen (nombre, web, language, nota_legal)>
<!ELEMENT nombre (#PCDATA)>
<!ELEMENT web (#PCDATA)>
<!ELEMENT language (#PCDATA)>
<!ELEMENT nota_legal (#PCDATA)>

<!ELEMENT elaborado (#PCDATA)>

<!ELEMENT tarifas (tarifa+)>
<!ATTLIST tarifas moneda CDATA #REQUIRED>

<!ELEMENT tarifa (descripcion, (precio_hora, max_diario | precio_mensual, acceso_24h))>
<!ATTLIST tarifa
  id   CDATA #REQUIRED
  tipo CDATA #REQUIRED
>
<!ELEMENT descripcion (#PCDATA)>
<!ELEMENT precio_hora (#PCDATA)>
<!ELEMENT max_diario (#PCDATA)>
<!ELEMENT precio_mensual (#PCDATA)>
<!ELEMENT acceso_24h (#PCDATA)>

<!ELEMENT plazas (plaza+)>
<!ATTLIST plazas total CDATA #REQUIRED>

<!ELEMENT plaza (matricula?, entrada?, observacion?, carga_kw?)>
<!ATTLIST plaza
  id     CDATA #REQUIRED
  planta CDATA #REQUIRED
  tipo   CDATA #REQUIRED
  estado CDATA #REQUIRED
>
<!ELEMENT matricula (#PCDATA)>
<!ELEMENT entrada (#PCDATA)>
<!ELEMENT observacion (#PCDATA)>
<!ELEMENT carga_kw (#PCDATA)>

<!ELEMENT abonados (abonado+)>
<!ELEMENT abonado (nombre, matricula, vigencia_desde, vigencia_hasta, tarifa_ref)>
<!ATTLIST abonado
  id   CDATA #REQUIRED
  tipo CDATA #REQUIRED
>
<!ELEMENT vigencia_desde (#PCDATA)>
<!ELEMENT vigencia_hasta (#PCDATA)>
<!ELEMENT tarifa_ref (#PCDATA)>

<!ELEMENT accesos (registro+)>
<!ELEMENT registro (fecha_hora, matricula, plaza_ref?)>
<!ATTLIST registro
  id     CDATA #REQUIRED
  evento CDATA #REQUIRED
>
<!ELEMENT fecha_hora (#PCDATA)>
<!ELEMENT plaza_ref (#PCDATA)>

//validaciones/parking_xsd-xml

<?xml version="1.0" encoding="UTF-8"?>
<parking xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="parking.xsd">
  <!-- pega aquí TODO el contenido exactamente igual al parking.xml original -->
</parking>



//validaciones/parking.xsd

<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="parking">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="origen" type="OrigenType"/>
        <xs:element name="elaborado" type="xs:dateTime"/>
        <xs:element name="tarifas" type="TarifasType"/>
        <xs:element name="plazas" type="PlazasType"/>
        <xs:element name="abonados" type="AbonadosType"/>
        <xs:element name="accesos" type="AccesosType"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  <xs:complexType name="OrigenType">
    <xs:sequence>
      <xs:element name="nombre" type="xs:string"/>
      <xs:element name="web" type="xs:string"/>
      <xs:element name="language" type="xs:string"/>
      <xs:element name="nota_legal" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="TarifasType">
    <xs:sequence>
      <xs:element name="tarifa" type="TarifaType" maxOccurs="unbounded"/>
    </xs:sequence>
    <xs:attribute name="moneda" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="TarifaType">
    <xs:sequence>
      <xs:element name="descripcion" type="xs:string"/>
      <xs:choice>
        <xs:sequence>
          <xs:element name="precio_hora" type="xs:decimal"/>
          <xs:element name="max_diario" type="xs:decimal"/>
        </xs:sequence>
        <xs:sequence>
          <xs:element name="precio_mensual" type="xs:decimal"/>
          <xs:element name="acceso_24h" type="xs:boolean"/>
        </xs:sequence>
      </xs:choice>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="PlazasType">
    <xs:sequence>
      <xs:element name="plaza" type="PlazaType" maxOccurs="unbounded"/>
    </xs:sequence>
    <xs:attribute name="total" type="xs:integer" use="required"/>
  </xs:complexType>

  <xs:complexType name="PlazaType">
    <xs:sequence>
      <xs:element name="matricula" type="xs:string" minOccurs="0"/>
      <xs:element name="entrada" type="xs:dateTime" minOccurs="0"/>
      <xs:element name="observacion" type="xs:string" minOccurs="0"/>
      <xs:element name="carga_kw" type="xs:integer" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="planta" type="xs:integer" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
    <xs:attribute name="estado" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="AbonadosType">
    <xs:sequence>
      <xs:element name="abonado" type="AbonadoType" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="AbonadoType">
    <xs:sequence>
      <xs:element name="nombre" type="xs:string"/>
      <xs:element name="matricula" type="xs:string"/>
      <xs:element name="vigencia_desde" type="xs:date"/>
      <xs:element name="vigencia_hasta" type="xs:date"/>
      <xs:element name="tarifa_ref" type="xs:string"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="AccesosType">
    <xs:sequence>
      <xs:element name="registro" type="RegistroType" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="RegistroType">
    <xs:sequence>
      <xs:element name="fecha_hora" type="xs:dateTime"/>
      <xs:element name="matricula" type="xs:string"/>
      <xs:element name="plaza_ref" type="xs:string" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="evento" type="xs:string" use="required"/>
  </xs:complexType>

</xs:schema>


parking_viewx.xml

<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="parking.xsl"?>
<parking>
  <!-- pega aquí TODO el contenido exactamente igual al parking.xml original -->
</parking>



parking.xsl

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <title>Parking GUEMI - Visualización (XSLT)</title>
      </head>
      <body>
        <h1>Parking GUEMI - Datos del XML</h1>

        <h2>Tarifas</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Descripción</th>
            <th>Precio/hora</th>
            <th>Máx diario</th>
            <th>Precio mensual</th>
            <th>Acceso 24h</th>
          </tr>
          <xsl:for-each select="parking/tarifas/tarifa">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="descripcion"/></td>
              <td><xsl:value-of select="precio_hora"/></td>
              <td><xsl:value-of select="max_diario"/></td>
              <td><xsl:value-of select="precio_mensual"/></td>
              <td><xsl:value-of select="acceso_24h"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Plazas</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Planta</th>
            <th>Tipo</th>
            <th>Estado</th>
            <th>Matrícula</th>
            <th>Entrada</th>
            <th>Observación</th>
            <th>Carga (kW)</th>
          </tr>
          <xsl:for-each select="parking/plazas/plaza">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@planta"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="@estado"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="entrada"/></td>
              <td><xsl:value-of select="observacion"/></td>
              <td><xsl:value-of select="carga_kw"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Abonados</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Matrícula</th>
            <th>Desde</th>
            <th>Hasta</th>
            <th>Tarifa ref</th>
          </tr>
          <xsl:for-each select="parking/abonados/abonado">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="vigencia_desde"/></td>
              <td><xsl:value-of select="vigencia_hasta"/></td>
              <td><xsl:value-of select="tarifa_ref"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Accesos (entradas y salidas)</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Evento</th>
            <th>Fecha/Hora</th>
            <th>Matrícula</th>
            <th>Plaza ref</th>
          </tr>
          <xsl:for-each select="parking/accesos/registro">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@evento"/></td>
              <td><xsl:value-of select="fecha_hora"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="plaza_ref"/></td>
            </tr>
          </xsl:for-each>
        </table>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

index.html 

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Web informativa del Parking GUEMI: ocupación, tarifas, abonados y registro de accesos.">
  <title>Parking GUEMI - Inicio</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>

    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Parking GUEMI Centro · Información y gestión</figcaption>
    </figure>

    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Bienvenido</h2>
      <p>
        Esta web muestra información del <strong>Parking GUEMI Centro</strong>.
        Aquí podrás consultar tarifas, plazas, abonados y el registro de accesos.
      </p>

      <article>
        <h3>Accesos rápidos</h3>
        <ul>
          <li><a href="tarifas.html">Ver tarifas</a></li>
          <li><a href="plazas.html">Ver plazas y estados</a></li>
          <li><a href="visualizacion.html">Ver el XML transformado con XSLT</a></li>
        </ul>
      </article>

      <article>
        <h3>Información práctica</h3>
        <table style="border: 1px solid black;" cellpadding="6" cellspacing="2" width="100%">
          <tr>
            <th scope="col">Dato</th>
            <th scope="col">Detalle</th>
          </tr>
          <tr>
            <td>Ubicación</td>
            <td>C/ Gran Vía 123, Zona Centro (inventado)</td>
          </tr>
          <tr>
            <td>Horario de atención</td>
            <td>L-V 08:00 a 20:00 · Sábados 09:00 a 14:00 (inventado)</td>
          </tr>
          <tr>
            <td>Contacto rápido</td>
            <td>Tel. 900 123 456 · Email: info@parking-guemi.es (inventado)</td>
          </tr>
          <tr>
            <td>Enlace externo</td>
            <td><a href="https://www.parking-guemi.es" target="_blank" rel="noopener">Web oficial</a></td>
          </tr>
        </table>
      </article>
    </section>

    <section>
      <h2>Normas de uso (resumen)</h2>
      <ol>
        <li>Respeta la señalización y límites de velocidad.</li>
        <li>Estaciona dentro de las líneas y deja espacio de paso.</li>
        <li>Si una plaza está en mantenimiento, no la utilices.</li>
        <li>En plazas PMR, aparcar solo con autorización.</li>
      </ol>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p>
      <a href="https://www.parking-guemi.es/legal" target="_blank" rel="noopener">Nota legal</a>
      · <a href="contacto.html">Contacto</a>
    </p>
  </footer>
</body>
</html>


visualizacion.html


<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Visualización del XML del Parking GUEMI mediante XSLT.">
  <title>Parking GUEMI - Visualización XML</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Visualización del XML con XSLT</figcaption>
    </figure>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Ver datos desde el XML</h2>
      <p>
        El archivo recomendado para visualizar es:
        <a href="parking_view.xml">parking_view.xml</a>
      </p>

      <article>
        <h3>¿Qué verás?</h3>
        <ul>
          <li>Tarifas del parking.</li>
          <li>Plazas con atributos (id, planta, tipo, estado).</li>
          <li>Abonados (vigencias y tarifa asociada).</li>
          <li>Registro de accesos (entradas y salidas).</li>
        </ul>
      </article>
    </section>

    <section>
      <h2>Vista incrustada (opcional)</h2>
      <p>Si tu navegador lo permite, aquí aparece la transformación dentro de la web:</p>
      <iframe src="parking_view.xml" width="100%" height="560"></iframe>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="index.html">Inicio</a> · <a href="https://www.parking-guemi.es" target="_blank" rel="noopener">Web externa</a></p>
  </footer>
</body>
</html>

//contacto.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Formulario de contacto del Parking GUEMI.">
  <title>Parking GUEMI - Contacto</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Atención al cliente</figcaption>
    </figure>

    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Contacta con nosotros</h2>
      <p>
        Resolvemos consultas sobre tarifas, abonados, plazas y accesos.
        Tiempo medio de respuesta: 24/48h (inventado).
      </p>

      <article>
        <h3>Formulario</h3>
        <form action="#" method="GET">
          <fieldset>
            <legend>Datos de la consulta</legend>

            <p>
              <label for="nombre">Nombre y apellidos:</label><br>
              <input type="text" id="nombre" name="nombre" placeholder="Ej: Ana García">
            </p>

            <p>
              <label for="email">Email:</label><br>
              <input type="email" id="email" name="email" placeholder="ejemplo@correo.com">
            </p>

            <p>
              <label for="matricula">Matrícula (si aplica):</label><br>
              <input type="text" id="matricula" name="matricula" placeholder="1234ABC">
            </p>

            <p>
              <label for="tipo">Tipo de consulta:</label><br>
              <select id="tipo" name="tipo">
                <option value="tarifas">Tarifas</option>
                <option value="abonados">Abonos</option>
                <option value="plazas">Plazas</option>
                <option value="accesos">Accesos</option>
                <option value="otros">Otros</option>
              </select>
            </p>

            <p>
              <label for="mensaje">Mensaje:</label><br>
              <textarea id="mensaje" name="mensaje" rows="6" cols="35"
                placeholder="Escribe aquí tu consulta..."></textarea>
            </p>

            <p>
              <button type="submit">Enviar</button>
              <button type="reset">Limpiar</button>
            </p>
          </fieldset>
        </form>
      </article>

      <article>
        <h3>Otras vías de contacto (inventadas)</h3>
        <ul>
          <li>Teléfono: 900 123 456</li>
          <li>Email: info@parking-guemi.es</li>
          <li>Oficina: Planta 0, junto al ascensor</li>
        </ul>

        <p>
          Consulta la <a href="https://www.parking-guemi.es/legal" target="_blank" rel="noopener">nota legal</a>.
        </p>
      </article>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="index.html">Inicio</a> · <a href="visualizacion.html">Visualización XML</a></p>
  </footer>
</body>
</html>

//accesos.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Registro de accesos del Parking GUEMI: entradas y salidas.">
  <title>Parking GUEMI - Accesos</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Registro de entradas y salidas</figcaption>
    </figure>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Tipos de evento</h2>
      <ol>
        <li>entrada</li>
        <li>salida</li>
      </ol>
    </section>

    <section>
      <h2>Registro (muestra)</h2>
      <p>
        Esta tabla incluye registros de ejemplo basados en el XML. Para ver todo:
        <a href="visualizacion.html">Visualización XML</a>.
      </p>

      <table style="border: 1px solid black;" cellpadding="6" cellspacing="2" width="100%">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Evento</th>
          <th scope="col">Fecha/Hora</th>
          <th scope="col">Matrícula</th>
          <th scope="col">Plaza ref</th>
          <th scope="col">Comentario</th>
        </tr>
        <tr>
          <td>R-001</td>
          <td>entrada</td>
          <td>2025-12-01T07:45:00</td>
          <td>1234KLM</td>
          <td>PZ-001</td>
          <td>Entrada en hora de oficina (inventado)</td>
        </tr>
        <tr>
          <td>R-002</td>
          <td>entrada</td>
          <td>2025-12-01T08:10:00</td>
          <td>5678BCD</td>
          <td>PZ-003</td>
          <td>Ocupación moto en planta -1 (inventado)</td>
        </tr>
        <tr>
          <td>R-003</td>
          <td>salida</td>
          <td>2025-12-01T08:25:00</td>
          <td>9999ZZZ</td>
          <td>(sin plaza)</td>
          <td>Salida rápida (plaza no registrada) (inventado)</td>
        </tr>
        <tr>
          <td>R-004</td>
          <td>entrada</td>
          <td>2025-12-01T06:55:00</td>
          <td>9012FGH</td>
          <td>PZ-006</td>
          <td>Vehículo eléctrico · recarga disponible (inventado)</td>
        </tr>
      </table>

      <article>
        <h3>Buenas prácticas (inventadas)</h3>
        <ul>
          <li>Si tu matrícula no aparece en el ticket, revisa el cajero antes de salir.</li>
          <li>En horas punta, utiliza el acceso de la calle lateral (inventado).</li>
          <li>Para abonados, se recomienda comprobar vigencia antes de entrar.</li>
        </ul>
      </article>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="index.html">Inicio</a> · <a href="contacto.html">Contacto</a></p>
  </footer>
</body>
</html>


//abonados.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Gestión informativa de abonados del Parking GUEMI.">
  <title>Parking GUEMI - Abonados</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Abonados y vigencias</figcaption>
    </figure>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Abonados activos (muestra)</h2>
      <p>
        Aquí se muestra un ejemplo. El detalle completo se puede consultar desde el XML:
        <a href="visualizacion.html">Visualización XML</a>.
      </p>

      <table style="border: 1px solid black;" cellpadding="6" cellspacing="2" width="100%">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Tipo</th>
          <th scope="col">Nombre</th>
          <th scope="col">Matrícula</th>
          <th scope="col">Vigencia</th>
          <th scope="col">Tarifa asociada</th>
        </tr>
        <tr>
          <td>A-001</td>
          <td>mensual</td>
          <td>María López</td>
          <td>1111AAA</td>
          <td>2025-01-01 a 2025-12-31</td>
          <td>T-002</td>
        </tr>
        <tr>
          <td>A-002</td>
          <td>nocturno</td>
          <td>Carlos Pérez</td>
          <td>2222BBB</td>
          <td>2025-06-01 a 2025-12-31</td>
          <td>T-003</td>
        </tr>
        <tr>
          <td>A-003</td>
          <td>mensual</td>
          <td>Lucía Sánchez</td>
          <td>3333CCC</td>
          <td>2025-09-01 a 2026-08-31</td>
          <td>T-002</td>
        </tr>
      </table>

      <article>
        <h3>Ventajas del abono (inventadas)</h3>
        <ul>
          <li>Acceso más rápido en horas punta.</li>
          <li>Asistencia prioritaria ante incidencias.</li>
          <li>Recordatorio de renovación (cuando está disponible, inventado).</li>
        </ul>
      </article>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="tarifas.html">Ver tarifas</a> · <a href="contacto.html">Contacto</a></p>
  </footer>
</body>
</html>

//plazas.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Plazas del Parking GUEMI: tipos, estado y recomendaciones.">
  <title>Parking GUEMI - Plazas</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Plazas y ocupación</figcaption>
    </figure>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Tipos de plaza</h2>
      <p>
        El parking cuenta con varias categorías de plaza para cubrir necesidades distintas.
      </p>

      <ul>
        <li><strong>Coche:</strong> plazas estándar.</li>
        <li><strong>Moto:</strong> plazas compactas.</li>
        <li><strong>PMR:</strong> plazas accesibles para movilidad reducida.</li>
        <li><strong>Eléctrico:</strong> plazas con punto de carga.</li>
      </ul>
    </section>

    <section>
      <h2>Estado actual (muestra)</h2>
      <p>
        En esta tabla aparece un ejemplo de plazas. Para el listado completo desde XML:
        <a href="visualizacion.html">Visualización XML</a>.
      </p>

      <table style="border: 1px solid black;" cellpadding="6" cellspacing="2" width="100%">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Planta</th>
          <th scope="col">Tipo</th>
          <th scope="col">Estado</th>
          <th scope="col">Notas</th>
        </tr>
        <tr>
          <td>PZ-001</td>
          <td>-1</td>
          <td>coche</td>
          <td>ocupada</td>
          <td>Entrada registrada · matrícula visible en XML</td>
        </tr>
        <tr>
          <td>PZ-002</td>
          <td>-1</td>
          <td>coche</td>
          <td>libre</td>
          <td>Recomendada para estancias cortas (inventado)</td>
        </tr>
        <tr>
          <td>PZ-004</td>
          <td>0</td>
          <td>pmr</td>
          <td>libre</td>
          <td>Acceso cercano al ascensor (inventado)</td>
        </tr>
        <tr>
          <td>PZ-005</td>
          <td>0</td>
          <td>coche</td>
          <td>mantenimiento</td>
          <td>No disponible: revisión de sensores</td>
        </tr>
        <tr>
          <td>PZ-006</td>
          <td>1</td>
          <td>electrico</td>
          <td>ocupada</td>
          <td>Carga activa en horario permitido (inventado)</td>
        </tr>
      </table>

      <article>
        <h3>Recomendaciones de aparcamiento</h3>
        <ol>
          <li>Si buscas rapidez, planta 0 suele tener mejor salida (inventado).</li>
          <li>Para recarga eléctrica, revisa disponibilidad antes de entrar.</li>
          <li>Evita zonas marcadas como “mantenimiento”.</li>
        </ol>
      </article>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="index.html">Inicio</a> · <a href="contacto.html">Contacto</a></p>
  </footer>
</body>
</html>


//tarifas.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Tarifas del Parking GUEMI: rotación y abonos.">
  <title>Parking GUEMI - Tarifas</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="160">
      <figcaption>Tarifas y modalidades</figcaption>
    </figure>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="visualizacion.html">Visualización XML</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
    <hr>
  </header>

  <main>
    <section>
      <h2>Tarifas disponibles</h2>
      <p>
        Estas tarifas son las modalidades más comunes del parking.
        Para ver el detalle exacto desde el XML: <a href="visualizacion.html">Visualización XML</a>.
      </p>

      <table style="border: 1px solid black;" cellpadding="6" cellspacing="2" width="100%">
        <tr>
          <th scope="col">Modalidad</th>
          <th scope="col">Descripción</th>
          <th scope="col">Precio</th>
          <th scope="col">Condiciones</th>
        </tr>
        <tr>
          <td>Rotación</td>
          <td>Estancias por horas</td>
          <td>2,20 €/hora</td>
          <td>Máximo diario 18,00 €</td>
        </tr>
        <tr>
          <td>Abono mensual</td>
          <td>Acceso frecuente</td>
          <td>95,00 €/mes</td>
          <td>Acceso 24h: Sí</td>
        </tr>
        <tr>
          <td>Abono nocturno</td>
          <td>Ideal para turnos de noche</td>
          <td>55,00 €/mes</td>
          <td>Acceso 24h: No</td>
        </tr>
      </table>

      <article>
        <h3>Preguntas frecuentes</h3>
        <ul>
          <li><strong>¿Hay descuento por varios meses?</strong> Sí, packs trimestrales (inventado).</li>
          <li><strong>¿Se puede cambiar de abono?</strong> Sí, con aviso de 7 días (inventado).</li>
          <li><strong>¿Qué métodos de pago hay?</strong> Tarjeta y efectivo en cajero (inventado).</li>
        </ul>
      </article>

      <article>
        <h3>Enlace externo útil</h3>
        <p>
          Consulta condiciones generales en:
          <a href="https://www.parking-guemi.es/legal" target="_blank" rel="noopener">Nota legal</a>
        </p>
      </article>
    </section>
  </main>

  <footer>
    <hr>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
    <p><a href="index.html">Volver a inicio</a> · <a href="contacto.html">Contacto</a></p>
  </footer>
</body>
</html>



//parking dtd.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE parking SYSTEM "parking.dtd">
<parking>
  <!-- pega aquí TODO el contenido exactamente igual al parking.xml original -->
</parking>
