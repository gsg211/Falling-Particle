# Falling-Particle Simulation

This project is a **Falling Particle Simulation** built using **Java** and the **Processing library**. It simulates the behavior of particles falling under gravity and includes interactive mechanics inspired by real-world chemistry reactions and physics.

### Features:
- **Falling Particles**: Simulate the movement of particles influenced by gravity.
- **Reaction Mechanic**: Inspired by chemistry, materials interact with each other in a reactive way when they come into contact. This adds an extra layer of realism to the simulation.
- **Density**: Each material has a density value that affects how it falls and interacts with other materials. Denser materials fall faster, while lighter ones float or behave differently.
- **Fluids**: Fluid dynamics are implemented, allowing certain materials to flow and interact like liquids. These materials spread and settle in their surroundings based on their properties.
- **Fire**: The simulation includes a fire mechanic where certain materials can ignite and burn when they come into contact with fire. The spread and behavior of fire are influenced by the density and flammability of surrounding materials.

### Reaction Mechanism:
The core of the reaction mechanic involves a method that checks if two materials (a reactant and a particle) interact when they collide. If they do, a new material replaces the reactant, and the original particle is replaced by a new product.

Here is the relevant code for the reaction mechanic:

```java
public void reactWithMaterial(MaterialGrid grid, Material reactant, Material product, Material reactantProduct) {
    // reactant is the other material needed for the reaction
    // product is the material that this material is replaced by
    // reactantProduct is the material that the reactant is replaced by

    Material result = checkForMaterial(grid, reactant);
    //println(result.type+": "+(x-result.x) + " "+ (y-result.y) );
    if (result.type == reactant.type) {
        replaceMaterial(grid, product);
        result.replaceMaterial(grid, reactantProduct);
    }
}
```

This mechanic allows for dynamic interactions between materials, creating interesting chain reactions and behaviors within the simulation.

### Demo:

To get a better understanding of how the simulation works, check out the demo GIF below:

![Demo](readmeResources/demo.gif)

---