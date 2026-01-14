const categories = [
    { id: 'corte', name: 'Corte', icon: '✂️' },
    { id: 'barba', name: 'Barba', icon: '🧔' },
    { id: 'color', name: 'Tinte', icon: '🎨' },
    { id: 'extras', name: 'Extras', icon: '✨' }
];

const services = [
    {
        id: 1,
        categoryId: 'corte',
        name: 'Corte Clásico',
        price: 15.00,
        image: 'https://images.unsplash.com/photo-1622020037042-567c6d6349d9?q=80&w=2074&auto=format&fit=crop',
        description: 'Tijera y máquina, acabado natural.'
    },
    {
        id: 2,
        categoryId: 'corte',
        name: 'Fade / Degradado',
        price: 18.00,
        image: 'https://images.unsplash.com/photo-1599351431202-1e0f0137899a?q=80&w=1980&auto=format&fit=crop',
        description: 'Degradado a piel, perfilado perfecto.'
    },
    {
        id: 3,
        categoryId: 'corte',
        name: 'Corte a Tijera',
        price: 20.00,
        image: 'https://images.unsplash.com/photo-1621605815971-fbc98d665033?q=80&w=2070&auto=format&fit=crop',
        description: 'Todo a tijera, estilo clásico y elegante.'
    },
    {
        id: 4,
        categoryId: 'barba',
        name: 'Arreglo de Barba',
        price: 10.00,
        image: 'https://images.unsplash.com/photo-1621605815971-fbc98d665033?q=80&w=2070&auto=format&fit=crop', // Placeholder reuse
        description: 'Perfilado y rebajado de volumen.'
    },
    {
        id: 5,
        categoryId: 'barba',
        name: 'Ritual Barba Completa',
        price: 22.00,
        image: 'https://images.unsplash.com/photo-1503951914875-befbb7135952?q=80&w=2080&auto=format&fit=crop',
        description: 'Toalla caliente, aceites esenciales y afeitado.'
    },
    {
        id: 6,
        categoryId: 'color',
        name: 'Tinte Completo',
        price: 35.00,
        image: 'https://images.unsplash.com/photo-1605497788044-5a32c7078486?q=80&w=1974&auto=format&fit=crop',
        description: 'Cobertura total de canas o cambio de look.'
    },
    {
        id: 7,
        categoryId: 'color',
        name: 'Mechas',
        price: 45.00,
        image: 'https://images.unsplash.com/photo-1605497788044-5a32c7078486?q=80&w=1974&auto=format&fit=crop',
        description: 'Iluminación y contraste para tu cabello.'
    },
    {
        id: 8,
        categoryId: 'extras',
        name: 'Masaje Capilar',
        price: 8.00,
        image: 'https://images.unsplash.com/photo-1516975080664-ed2fc6a32937?q=80&w=2070&auto=format&fit=crop',
        description: 'Relajante lavado con masaje de 10 min.'
    }
];

const timeSlots = [
    '10:00', '10:30', '11:00', '11:30', '12:00', '12:30',
    '16:00', '16:30', '17:00', '17:30', '18:00', '18:30', '19:00'
];
