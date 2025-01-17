package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {
    private ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(
                new Experience("Paseo en bicicleta por el Montseny","Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny", "Una escapada veraniega perfecta para parejas, familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. " +
                        "El recorrido que os proponemos comienza con una larga subida con algunos descansos, combinando asfalto y pistas anchas, culminando en un mirador con magníficas vistas del Vallés y el mar.Desde aquí continuaremos la bajada combinando senderos, " +
                        "pistas y algún tramo de carretera y terreno mixto para visitar la zona de Santa Fe, donde descubriremos la Ermita y el Bosque de las Secuoyas. " + "Para finalizar, acudiremos al restaurante María Rosa de Palautordera, " +
                        "donde disfrutaremos de una excelente comida casera con butifarra blanca y negra y munxetes del Montseny", 250, "5h", "montaña, bicicleta, excursión larga", "https://media.revistagq.com/photos/603f9b08ea88c7db6f596dd7/16:9/w_2560%2Cc_limit/dick-honing-XCLGjBwKvSw-unsplash%2520(1).jpg") ,


                new Experience("Descubre la costa en barco de vela","Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona.", "Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. \n" +
                        "Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. \n" +
                        "A bordo de la embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, pararemos cerca de la Playa de Montgat para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. " +
                        "Finalizaremos la excursión en el mismo puerto del que partimos", 280, "4h", "playa, barco, excursion larga", "https://c.pxhere.com/photos/2a/51/ship_boat_vessel_dock_mooring_mast_bow_stern-420002.jpg!s1"),


                new Experience("Descubre la Barcelona Modernista de noche","Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés", "distrito del Eixample, ubicado en el centro de la ciudad. En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y edificios más célebres del arquitecto Gaudí. \n" +
                        "El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú para niños. " +
                        "Cava aparte.\n", 200, "4h", "ciudad, pie,excursion larga", "https://bcityng.com/wp-content/uploads/elementor/thumbs/raimond-klavins-18iU7bHCjeo-unsplash-2-scaled-e1627383735291-paqaw04px7s3cn0u8l2a9omu019e6i6vwg018n01iw.jpg"),


                new Experience("Del huerto a la mesa","Comparte con los más pequeños las maravillas de la naturaleza.", "En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig. Durante una hora y media, aprenderéis a cuidar de vuestro propio huerto, plantaréis y abonaréis vuestras propias plantas, y también recogeréis parte de los ingredientes que los expertos chefs de Can Gilabert utilizarán para preparar la posterior cena, donde disfrutaréis de la experiencia de consumir productos recién recogidos de la tierra con vuestras propias manos. " +
                        "Actividad ideal para familiarizar a los más pequeños de la familia con el estilo de vida rural y la agricultura sostenible. Asimismo, obtendréis como obsequio una botella de aceite virgen extra cultivado y preparado en Can Gilabert, obra de la familia Gilabert, " +
                        "que lleva más de 80 años cultivando olivos.", 145, "3h", "montaña, a pie, excursion corta", "https://parquesalegres.org/wp-content/uploads/2020/11/huertos-y-ni%C3%B1os.jpg\n"),


                new Experience("Arte en la montaña sagrada","Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch", ", lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. " +
                        "Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, " +
                        "cava brut o refresco.", 125, "2h", "montaña, a pie, excursion corta", "https://guias-viajar.com/wp-content/uploads/2017/05/barcelona-monasterio-monserrat-001.jpg\n")
        ));
    }
}


