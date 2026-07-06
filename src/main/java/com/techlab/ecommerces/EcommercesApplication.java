package com.techlab.ecommerces;

import com.techlab.ecommerces.model.Accesorio;
import com.techlab.ecommerces.model.Categoria;
import com.techlab.ecommerces.model.Indumentaria;
import com.techlab.ecommerces.service.CategoriaService;
import com.techlab.ecommerces.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommercesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercesApplication.class, args);
	}

	@Bean
	CommandLineRunner cargarDatos(CategoriaService categoriaService, ProductoService productoService) {
		return args -> {
			if (categoriaService.listarTodas().isEmpty()) {

				Categoria remeras = categoriaService.guardar(new Categoria(null, "Remeras y musculosas", "Remeras, musculosas y tops"));
				Categoria pantalones = categoriaService.guardar(new Categoria(null, "Pantalones y jeans", "Jeans, joggers y pantalones de vestir"));
				Categoria camperas = categoriaService.guardar(new Categoria(null, "Camperas y abrigos", "Camperas, buzos y sweaters"));
				Categoria calzado = categoriaService.guardar(new Categoria(null, "Calzado", "Zapatillas, botas y sandalias"));
				Categoria bijouterie = categoriaService.guardar(new Categoria(null, "Bijouterie y accesorios", "Carteras, cinturones y accesorios"));

				// Indumentaria — Remeras
				Indumentaria r1 = new Indumentaria("Remera básica algodón", 12.99, 40, "Palermo", "Unisex", "M");
				r1.setCategoria(remeras);
				productoService.guardar(r1);

				Indumentaria r2 = new Indumentaria("Musculosa deportiva", 9.50, 35, "Belgrano", "Femenino", "S");
				r2.setCategoria(remeras);
				productoService.guardar(r2);

				// Indumentaria — Pantalones
				Indumentaria p1 = new Indumentaria("Jean recto azul", 34.99, 25, "Once", "Masculino", "42");
				p1.setCategoria(pantalones);
				productoService.guardar(p1);

				Indumentaria p2 = new Indumentaria("Jogger negro", 27.50, 30, "Flores", "Unisex", "L");
				p2.setCategoria(pantalones);
				productoService.guardar(p2);

				// Indumentaria — Camperas
				Indumentaria c1 = new Indumentaria("Campera de jean", 38.50, 15, "Caballito", "Femenino", "M");
				c1.setCategoria(camperas);
				productoService.guardar(c1);

				Indumentaria c2 = new Indumentaria("Buzo canguro gris", 22.00, 28, "Villa Urquiza", "Unisex", "L");
				c2.setCategoria(camperas);
				productoService.guardar(c2);

				// Accesorios — Calzado
				Accesorio z1 = new Accesorio("Zapatillas urbanas blancas", 55.99, 18, "Suela de goma antideslizante");
				z1.setCategoria(calzado);
				productoService.guardar(z1);

				Accesorio z2 = new Accesorio("Botas de cuero", 78.00, 10, "Cuero genuino, ideales para invierno");
				z2.setCategoria(calzado);
				productoService.guardar(z2);

				// Accesorios — Bijouterie
				Accesorio b1 = new Accesorio("Cartera de mano negra", 45.00, 12, "Compartimento interno con cierre");
				b1.setCategoria(bijouterie);
				productoService.guardar(b1);

				Accesorio b2 = new Accesorio("Cinturón de cuero marrón", 18.50, 20, "Hebilla metálica clásica");
				b2.setCategoria(bijouterie);
				productoService.guardar(b2);
			}
		};
	}
}